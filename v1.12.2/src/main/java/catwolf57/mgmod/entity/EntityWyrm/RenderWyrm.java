package catwolf57.mgmod.entity.EntityWyrm;

import catwolf57.mgmod.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderWyrm extends RenderLiving<EntityWyrm>{
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/wyrm.png");
	
	public RenderWyrm(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn) {
		super(rendermanagerIn, modelbaseIn, shadowsizeIn);
	}
	
	public RenderWyrm(RenderManager manager) {
		super(manager, new ModelWyrm(), 0.5F);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityWyrm entity) {
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityWyrm entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
}
