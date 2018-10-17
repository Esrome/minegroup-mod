package catwolf57.mgmod.entity.EntityWyrm;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelWyrm - Catwolf57
 * Created using Tabula 7.0.0
 */
public class ModelWyrm extends ModelBase {
    public ModelRenderer LeftWing;
    public ModelRenderer RightWing;
    public ModelRenderer Body;
    public ModelRenderer Tail;
    public ModelRenderer Head;
    public ModelRenderer EarLeft;
    public ModelRenderer EarRight;
    public ModelRenderer Snout;

    public ModelWyrm() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.LeftWing = new ModelRenderer(this, 48, 48);
        this.LeftWing.setRotationPoint(3.0F, 19.499999999999996F, 0.0F);
        this.LeftWing.addBox(0.0F, 0.0F, -6.0F, 8, 1, 12, 0.0F);
        this.setRotateAngle(LeftWing, -0.36145768808802564F, -0.1425933998879367F, -0.4279547325890095F);
        this.Body = new ModelRenderer(this, 64, 0);
        this.Body.setRotationPoint(-4.0F, 15.0F, -4.30000000000001F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 8, 4, 12, 0.0F);
        this.setRotateAngle(Body, -0.34574972482007665F, 0.0F, 0.0F);
        this.EarLeft = new ModelRenderer(this, 0, 0);
        this.EarLeft.setRotationPoint(4.5F, -14.0F, -7.5F);
        this.EarLeft.addBox(0.0F, 0.0F, 0.0F, 3, 6, 3, 0.0F);
        this.RightWing = new ModelRenderer(this, 0, 48);
        this.RightWing.setRotationPoint(-2.5F, 19.499999999999996F, 0.3F);
        this.RightWing.addBox(-8.0F, 0.0F, -6.0F, 8, 1, 12, 0.0F);
        this.setRotateAngle(RightWing, -0.36145768808802564F, 0.1425933998879367F, 0.42795473258900973F);
        this.Snout = new ModelRenderer(this, 0, 64);
        this.Snout.setRotationPoint(-4.0F, 0.0F, -18.0F);
        this.Snout.addBox(0.0F, 0.0F, 0.0F, 8, 4, 10, 0.0F);
        this.Tail = new ModelRenderer(this, 64, 28);
        this.Tail.setRotationPoint(-1.0F, 19.499999999999996F, 5.6F);
        this.Tail.addBox(0.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(Tail, -0.13578661580515886F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 16.0F, -6.3F);
        this.Head.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16, 0.0F);
        this.EarRight = new ModelRenderer(this, 0, 0);
        this.EarRight.setRotationPoint(-7.5F, -14.0F, -7.5F);
        this.EarRight.addBox(0.0F, 0.0F, 0.0F, 3, 6, 3, 0.0F);
        this.Head.addChild(this.EarLeft);
        this.Head.addChild(this.Snout);
        this.Head.addChild(this.EarRight);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.LeftWing.render(f5);
        this.Body.render(f5);
        this.RightWing.render(f5);
        this.Tail.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.Head.offsetX, this.Head.offsetY, this.Head.offsetZ);
        GlStateManager.translate(this.Head.rotationPointX * f5, this.Head.rotationPointY * f5, this.Head.rotationPointZ * f5);
        GlStateManager.scale(0.33D, 0.33D, 0.33D);
        GlStateManager.translate(-this.Head.offsetX, -this.Head.offsetY, -this.Head.offsetZ);
        GlStateManager.translate(-this.Head.rotationPointX * f5, -this.Head.rotationPointY * f5, -this.Head.rotationPointZ * f5);
        this.Head.render(f5);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    	this.LeftWing.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.RightWing.rotateAngleZ = -1 * (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount);
    	
    	this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.Head.rotateAngleX = headPitch * 0.017453292F;
    }
}
