package catwolf57.mgmod.blocks.froyo;

import catwolf57.mgmod.MinegroupMod;
import catwolf57.mgmod.blocks.item.ItemBlockVariant;
import catwolf57.mgmod.init.ModBlocks;
import catwolf57.mgmod.init.ModItems;
import catwolf57.mgmod.util.IHasModel;
import catwolf57.mgmod.util.IMetaName;
import catwolf57.mgmod.util.handlers.EnumHandler;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockFroyo extends Block implements IHasModel, IMetaName {

	public static final PropertyEnum<EnumHandler.EnumColorType> VARIANT = PropertyEnum.<EnumHandler.EnumColorType>create("variant", EnumHandler.EnumColorType.class);
	
	private String name;
	
	public BlockFroyo(String name) 
	{
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setSoundType(SoundType.STONE);
		setHardness(1.6F);
		setCreativeTab(MinegroupMod.MINEGROUP);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumColorType.WHITE));
		
		this.name = name;
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlockVariant(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		return ((EnumHandler.EnumColorType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((EnumHandler.EnumColorType)state.getValue(VARIANT)).getMeta();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumColorType.byMetadata(meta));
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) 
	{
		return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		for(EnumHandler.EnumColorType variant : EnumHandler.EnumColorType.values())
		{
			items.add(new ItemStack(this, 1, variant.getMeta()));
		}
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return EnumHandler.EnumColorType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < EnumHandler.EnumColorType.values().length; i++)
		{
			MinegroupMod.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "froyo_brick_" + EnumHandler.EnumColorType.values()[i].getName(), "inventory");
		}
	}
	
}
