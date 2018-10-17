package catwolf57.mgmod.init;

import catwolf57.mgmod.world.gen.biomes.BiomeWyrm;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomes {

	public static final Biome WYRM = new BiomeWyrm();
	
	public static void registerBiomes(){
		registerBiome(WYRM, "wyrm", BiomeType.COOL, Type.CONIFEROUS.SPOOKY.MAGICAL.FOREST.WET);
	}
	
	private static Biome registerBiome(Biome biome, String name, BiomeType biometype, Type... type){
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, type);
		BiomeManager.addBiome(biometype, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		return biome;
	}
	
}
