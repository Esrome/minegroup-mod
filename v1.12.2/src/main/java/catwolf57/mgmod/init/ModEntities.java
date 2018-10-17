package catwolf57.mgmod.init;

import catwolf57.mgmod.MinegroupMod;
import catwolf57.mgmod.entity.EntityWyrm.EntityWyrm;
import catwolf57.mgmod.util.Reference;
import catwolf57.mgmod.util.handlers.EntityIDHandler;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

	public static void registerEntities(){
		registerEntity("Wyrm", EntityWyrm.class, EntityIDHandler.ENTITY_WYRM, 24, 4063326, 7818649);
	}
	
	private static void registerEntity(String name, Class<?extends Entity> entity, int id, int range, int c1, int c2){
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, MinegroupMod.instance, range, 1, true, c1, c2);
	}
	
	private static void registerThrowableEntity(String name, Class<?extends Entity> entity, int id, int range){
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, MinegroupMod.instance, range, 1, true);
	}
	
}
