package catwolf57.mgmod.blocks;

import catwolf57.mgmod.MinegroupMod;
import catwolf57.mgmod.init.ModBlocks;
import catwolf57.mgmod.init.ModItems;
import catwolf57.mgmod.util.IHasModel;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockModStairs extends BlockStairs implements IHasModel {

	public BlockModStairs(IBlockState modelState, String name) {
		super(modelState);
		setSoundType(SoundType.WOOD);
		setHardness(0.8F);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinegroupMod.MINEGROUP);
        setLightOpacity(255);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean getUseNeighborBrightness(IBlockState state) {
		return true;
	}
	
	@Override
	public void registerModels() 
	{
		MinegroupMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
