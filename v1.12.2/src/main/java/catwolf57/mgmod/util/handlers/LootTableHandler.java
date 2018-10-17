package catwolf57.mgmod.util.handlers;

import catwolf57.mgmod.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {
	
	//use https://amaury.carrade.eu/minecraft/loot_tables for loot tables
	public static final ResourceLocation WYRM = LootTableList.register(new ResourceLocation(Reference.MODID, "entities/wyrm"));
	
}
