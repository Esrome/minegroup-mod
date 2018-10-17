package catwolf57.mgmod.blocks.slabs;

import java.util.Random;

import catwolf57.mgmod.MinegroupMod;
import catwolf57.mgmod.init.ModBlocks;
import catwolf57.mgmod.init.ModItems;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class WyrmBlockSlab extends BlockSlab {

	public WyrmBlockSlab(String name, Material material, float Hardness){
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(Hardness);
		
		IBlockState state = this.blockState.getBaseState();
		
		if(!this.isDouble()){
			state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}
		
		setDefaultState(state);
		this.useNeighborBrightness = true;
		
		this.setCreativeTab(MinegroupMod.MINEGROUP);
		

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public WyrmBlockSlab(String name, Material material, float Hardness, int HarvestLevel, String HarvestTool){
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(Hardness);
		setHarvestLevel(HarvestTool, HarvestLevel);
		
		IBlockState state = this.blockState.getBaseState();
		
		if(!this.isDouble()){
			state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}
		
		setDefaultState(state);
		this.useNeighborBrightness = true;
	}
	
	@Override
	protected boolean canSilkHarvest()
    {
        return false;
    }
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        IBlockState iblockstate = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);

        if (this.isDouble())
        {
            return iblockstate;
        }
        else
        {
            return facing != EnumFacing.DOWN && (facing == EnumFacing.UP || (double)hitY <= 0.5D) ? iblockstate : iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.TOP);
        }
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        if (this.isDouble())
        {
            return FULL_BLOCK_AABB;
        }
        else
        {
            return state.getValue(HALF) == BlockSlab.EnumBlockHalf.TOP ? AABB_TOP_HALF : AABB_BOTTOM_HALF;
        }
    }
	
	@Override
	public String getUnlocalizedName(int meta){
		return this.getUnlocalizedName();
	}
	
	@Override
	public IProperty<?> getVariantProperty() {
		return HALF;
	}
	
	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return EnumBlockHalf.BOTTOM;
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if(!this.isDouble()){
			return this.getDefaultState().withProperty(HALF, EnumBlockHalf.values()[meta % EnumBlockHalf.values().length]);
		}
		
		return this.getDefaultState();
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		if(!this.isDouble()){
			return 0;
		}
		
		return ((EnumBlockHalf)state.getValue(HALF)).ordinal() + 1;
		
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.WYRM_SLAB_HALF);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{HALF});
	}
	
}
