package catwolf57.mgmod.blocks;

import catwolf57.mgmod.MinegroupMod;
import catwolf57.mgmod.init.ModBlocks;
import catwolf57.mgmod.init.ModItems;
import catwolf57.mgmod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBase extends Block implements IHasModel {
	
	public BlockBase(String name, Material material, float toughness, int harvestlevel) 
	{
		super(material);
		if(!(harvestlevel == -1)){
			setHarvestLevel("pickaxe", harvestlevel);
		}
		if(material == Material.IRON){
			setSoundType(SoundType.METAL);
		}else{
			if(material == Material.ROCK){
				setSoundType(SoundType.STONE);
			}
		}
		setHardness(toughness);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinegroupMod.MINEGROUP);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	public BlockBase(String name, Material material, float toughness, int harvestlevel, SoundType type) 
	{
		super(material);
		if(!(harvestlevel == -1)){
			setHarvestLevel("pickaxe", harvestlevel);
		}
		setSoundType(type);
		setHardness(toughness);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MinegroupMod.MINEGROUP);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() 
	{
		MinegroupMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
}
