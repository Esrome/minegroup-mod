package catwolf57.mgmod.util.handlers;

import catwolf57.mgmod.entity.EntityWyrm.EntityWyrm;
import catwolf57.mgmod.entity.EntityWyrm.RenderWyrm;
import catwolf57.mgmod.entity.EntityWyrmFire.EntityWyrmFireball;
import catwolf57.mgmod.entity.EntityWyrmFire.RenderWyrmFireball;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {

	public static void registerEntityRenders(){
		RenderingRegistry.registerEntityRenderingHandler(EntityWyrm.class, new IRenderFactory<EntityWyrm>(){@Override public Render<? super EntityWyrm> createRenderFor(RenderManager manager) {return new RenderWyrm(manager);}	});
		RenderingRegistry.registerEntityRenderingHandler(EntityWyrmFireball.class, new IRenderFactory<EntityWyrmFireball>(){@Override public Render<? super EntityWyrmFireball> createRenderFor(RenderManager manager) {return new RenderWyrmFireball(manager, 1.0F);}	});
	}
	
}
