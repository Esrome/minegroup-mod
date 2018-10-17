package catwolf57.mgmod.world.gen.biomes;

import java.util.Random;

import catwolf57.mgmod.world.gen.trees.WorldGenWyrmTree;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeWyrm extends Biome {

	protected static final WorldGenAbstractTree tree = new WorldGenWyrmTree(true, false);
	
	public BiomeWyrm() {
		super(new BiomeProperties("wyrm").setBaseHeight(0.115F).setRainfall(1.0F).setTemperature(0.6F).setWaterColor(66).setHeightVariation(0.05F));
	
		topBlock = Blocks.GRASS.getDefaultState();
		fillerBlock = Blocks.DIRT.getDefaultState();
		
		this.decorator.treesPerChunk = 4;
	}
	
	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return tree;
	}

	@Override
	public int getModdedBiomeGrassColor(int original) {
		return 10512585;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return 10512585;
	}
	
}