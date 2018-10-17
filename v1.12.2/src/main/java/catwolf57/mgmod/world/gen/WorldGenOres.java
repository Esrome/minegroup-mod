package catwolf57.mgmod.world.gen;

import java.util.Random;

import catwolf57.mgmod.blocks.BlockOres;
import catwolf57.mgmod.init.ModBlocks;
import catwolf57.mgmod.util.handlers.EnumHandler;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenOres implements IWorldGenerator{

	private WorldGenerator ore_overworld_catwolfian, ore_overworld_destiny, ore_overworld_minegroup;
	
	public WorldGenOres(){
		ore_overworld_catwolfian = new WorldGenMinable(ModBlocks.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumOreType.CATWOLFIAN), 8, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_destiny = new WorldGenMinable(ModBlocks.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumOreType.DESTINY), 8, BlockMatcher.forBlock(Blocks.STONE));
		ore_overworld_minegroup = new WorldGenMinable(ModBlocks.ORE_OVERWORLD.getDefaultState().withProperty(BlockOres.VARIANT, EnumHandler.EnumOreType.MINEGROUP), 8, BlockMatcher.forBlock(Blocks.STONE));
	}
	
	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkx, int chunkz, int chance, int minHeight, int maxHeight){
		if (minHeight > maxHeight || minHeight < 0|| maxHeight > 256){
			throw new IllegalArgumentException("Ore out of bounds or heights are reversed.");
		}
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chance ; i++){
			int x = chunkx * 16 + rand.nextInt(16);
			int z = chunkz * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			gen.generate(world, rand, new BlockPos(x, y, z));
		}
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()){
		case 0:
			runGenerator(ore_overworld_catwolfian, world, random, chunkX, chunkZ, 1, 0, 24);
			runGenerator(ore_overworld_destiny, world, random, chunkX, chunkZ, 1, 0, 24);
			runGenerator(ore_overworld_minegroup, world, random, chunkX, chunkZ, 1, 0, 24);
			break;
		case -1:
			break;
		case 1:
			
		}
	}
	
}
