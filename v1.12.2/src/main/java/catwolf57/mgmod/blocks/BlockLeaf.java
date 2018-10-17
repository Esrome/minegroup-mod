package catwolf57.mgmod.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import catwolf57.mgmod.MinegroupMod;
import catwolf57.mgmod.blocks.item.ItemBlockVariant;
import catwolf57.mgmod.init.ModBlocks;
import catwolf57.mgmod.init.ModItems;
import catwolf57.mgmod.util.IHasModel;
import catwolf57.mgmod.util.IMetaName;
import catwolf57.mgmod.util.handlers.EnumHandler;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLeaf extends BlockLeaves implements IHasModel, IMetaName {

	public static final PropertyEnum<EnumHandler.EnumWoodType> VARIANT = PropertyEnum.<EnumHandler.EnumWoodType>create("variant", EnumHandler.EnumWoodType.class, new Predicate<EnumHandler.EnumWoodType>()
	{
		public boolean apply(@Nullable EnumHandler.EnumWoodType apply)
		{
			return apply.getMeta() < 1;
		}
	});
	
	private String name;
	
	public BlockLeaf(String name) 
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.PLANT);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumWoodType.WYRM).withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		setCreativeTab(MinegroupMod.MINEGROUP);
		
		this.name = name;
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariant(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumWoodType.byMetadata(meta % 2));
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	   {
	       return Item.getItemFromBlock(ModBlocks.MINEGROUP_SAPLINGS);
	   }
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		int i = ((EnumHandler.EnumWoodType)state.getValue(VARIANT)).getMeta();
		
		if(!((Boolean)state.getValue(DECAYABLE)).booleanValue())
		{
			i |= 2;
		}
		
		if(!((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
		{
			i |= 4;
		}
		
		return i;
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(EnumHandler.EnumWoodType customblockplanks$enumtype : EnumHandler.EnumWoodType.values())
		{
			items.add(new ItemStack(this, 1, customblockplanks$enumtype.getMeta()));
		}
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, ((EnumHandler.EnumWoodType)state.getValue(VARIANT)).getMeta());
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((EnumHandler.EnumWoodType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return EnumHandler.EnumWoodType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance) {
		int i = ((EnumHandler.EnumWoodType)state.getValue(VARIANT)).getMeta();
		ItemStack stack = null;
		Random rand = new Random();
		int j = 1 + rand.nextInt(25);
		if(i == 0 && j == 1){
			stack = new ItemStack(ModItems.WYRM_FRUIT, 1);
			EntityItem item = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
			worldIn.spawnEntity(item);
		}
		return;
	}
	
	@Override
	protected int getSaplingDropChance(IBlockState state) {return 30;}
	
	@Override
	public EnumType getWoodType(int meta) {
		return null;
	}
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) 
	{
		return NonNullList.withSize(1, new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).getMeta()));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT,DECAYABLE,CHECK_DECAY});
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() 
	{
		return BlockRenderLayer.TRANSLUCENT;
	}	
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < EnumHandler.EnumWoodType.values().length; i++)
		{
			MinegroupMod.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "leaves_" + EnumHandler.EnumWoodType.values()[i].getName(), "inventory");
		}
	}
	
}
