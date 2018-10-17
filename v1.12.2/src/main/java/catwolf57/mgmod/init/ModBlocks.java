package catwolf57.mgmod.init;

import java.util.ArrayList;
import java.util.List;

import catwolf57.mgmod.blocks.BlockBase;
import catwolf57.mgmod.blocks.BlockLeaf;
import catwolf57.mgmod.blocks.BlockLogs;
import catwolf57.mgmod.blocks.BlockModStairs;
import catwolf57.mgmod.blocks.BlockOres;
import catwolf57.mgmod.blocks.BlockPlanks;
import catwolf57.mgmod.blocks.BlockSaplings;
import catwolf57.mgmod.blocks.BlockWyrmFire;
import catwolf57.mgmod.blocks.froyo.BlockFroyo;
import catwolf57.mgmod.blocks.froyo.froyoFreezer.BlockFroyoFreezer;
import catwolf57.mgmod.blocks.slabs.WyrmBlockDoubleSlab;
import catwolf57.mgmod.blocks.slabs.WyrmBlockHalfSlab;
import catwolf57.mgmod.blocks.slabs.WyrmBlockSlab;
import catwolf57.mgmod.util.handlers.EnumHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block MINEGROUP_PLANKS = new BlockPlanks("plank");
	public static final Block MINEGROUP_LOGS = new BlockLogs("log");
	public static final Block MINEGROUP_LEAVES = new BlockLeaf("leaves");
	public static final Block MINEGROUP_SAPLINGS = new BlockSaplings("saplings");
	
	public static final Block FROYO_FREEZER = new BlockFroyoFreezer("froyo_freezer");

	//slabs
	public static final Block WYRM_SLAB_HALF = new WyrmBlockHalfSlab("wyrm_slab_half", Material.WOOD, 3.0F);
	public static final Block WYRM_SLAB_DOUBLE = new WyrmBlockDoubleSlab("wyrm_slab_double", Material.WOOD, 3.0F);
	
	//stairs
	public static final Block WYRM_STAIRS = new BlockModStairs(MINEGROUP_PLANKS.getBlockState().getBaseState().withProperty(BlockPlanks.VARIANT, EnumHandler.EnumWoodType.WYRM), "stairs_wyrm");
	public static final Block CATWOLFIAN_STAIRS = new BlockModStairs(MINEGROUP_PLANKS.getBlockState().getBaseState().withProperty(BlockPlanks.VARIANT, EnumHandler.EnumWoodType.CATWOLFIAN), "stairs_catwolfian");
	public static final Block DESTINED_STAIRS = new BlockModStairs(MINEGROUP_PLANKS.getBlockState().getBaseState().withProperty(BlockPlanks.VARIANT, EnumHandler.EnumWoodType.DESTINED), "stairs_destined");
	public static final Block FROYO_STAIRS = new BlockModStairs(MINEGROUP_PLANKS.getBlockState().getBaseState().withProperty(BlockPlanks.VARIANT, EnumHandler.EnumWoodType.FROYO), "stairs_froyo");
	
	public static final Block ORE_OVERWORLD = new BlockOres("ore_overworld", "overworld");
	public static final Block MINEGROUP_BLOCK = new BlockBase("minegroup_block", Material.IRON, 1.5F, 2);
	public static final Block WYRM_FIRE = new BlockWyrmFire().setUnlocalizedName("wyrm_fire").setRegistryName("wyrm_fire");
	public static final Block FROYO = new BlockFroyo("froyo_brick");
	
}
