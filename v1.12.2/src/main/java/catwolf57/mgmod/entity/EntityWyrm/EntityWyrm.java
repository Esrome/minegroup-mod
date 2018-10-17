package catwolf57.mgmod.entity.EntityWyrm;

import catwolf57.mgmod.util.handlers.LootTableHandler;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityFlying;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityWyrm extends EntityMob implements EntityFlying{

	private float heightOffset = 0.5F;
    private int heightOffsetUpdateTime;
    private static final DataParameter<Byte> ON_FIRE = EntityDataManager.<Byte>createKey(EntityWyrm.class, DataSerializers.BYTE);
	
	public EntityWyrm(World worldIn)
    {
        super(worldIn);
        this.setSize(1F, 0.5F);
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        this.setPathPriority(PathNodeType.LAVA, 8.0F);
        this.setPathPriority(PathNodeType.DANGER_FIRE, 0.0F);
        this.setPathPriority(PathNodeType.DAMAGE_FIRE, 0.0F);
        this.isImmuneToFire = true;
        this.experienceValue = 10;
    }
    
	public static void registerFixeswyrm(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityWyrm.class);
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(4, new EntityWyrm.AIFireballAttack(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D, 0.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(48.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0F);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.1D);
        this.getEntityAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.6D);
    }
    
    protected PathNavigate createNavigator(World worldIn)
    {
        PathNavigateFlying pathnavigateflying = new PathNavigateFlying(this, worldIn);
        pathnavigateflying.setCanOpenDoors(false);
        pathnavigateflying.setCanFloat(true);
        pathnavigateflying.setCanEnterDoors(true);
        return pathnavigateflying;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(ON_FIRE, Byte.valueOf((byte)0));
    }

    public void onLivingUpdate()
    {
        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        if (this.world.isRemote)
        {
            if (this.rand.nextInt(24) == 0 && !this.isSilent())
            {
                //this.world.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, SoundEvents.ENTITY_WYRM_BURN, this.getSoundCategory(), 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
            }

            for (int i = 0; i < 2; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
            }
        }

        super.onLivingUpdate();
    }

    protected void updateAITasks()
    {

        --this.heightOffsetUpdateTime;

        if (this.heightOffsetUpdateTime <= 0)
        {
            this.heightOffsetUpdateTime = 100;
            this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
        }

        EntityLivingBase entitylivingbase = this.getAttackTarget();

        if (entitylivingbase != null && entitylivingbase.posY + (double)entitylivingbase.getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset)
        {
            this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
            this.isAirBorne = true;
        }

        super.updateAITasks();
    }

    public void fall(float distance, float damageMultiplier)
    {
    }

    /**
     * Returns true if the entity is on fire. Used by render to add the fire effect on rendering.
     */
    public boolean isBurning()
    {
       return (((Byte)this.dataManager.get(ON_FIRE)).byteValue() & 1) != 0;
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return LootTableHandler.WYRM;
    }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    protected boolean isValidLightLevel()
    {
        return true;
    }

    static class AIFireballAttack extends EntityAIBase
        {
            private final EntityWyrm wyrm;
            private int attackStep;
            private int attackTime;

            public AIFireballAttack(EntityWyrm wyrmIn)
            {
                this.wyrm = wyrmIn;
                this.setMutexBits(3);
            }

            /**
             * Returns whether the EntityAIBase should begin execution.
             */
            public boolean shouldExecute()
            {
                EntityLivingBase entitylivingbase = this.wyrm.getAttackTarget();
                return entitylivingbase != null && entitylivingbase.isEntityAlive();
            }

            /**
             * Execute a one shot task or start executing a continuous task
             */
            public void startExecuting()
            {
                this.attackStep = 0;
            }
            public void updateTask()
            {
                --this.attackTime;
                EntityLivingBase entitylivingbase = this.wyrm.getAttackTarget();
                double d0 = this.wyrm.getDistanceSq(entitylivingbase);

                if (d0 < 4.0D)
                {
                    if (this.attackTime <= 0)
                    {
                        this.attackTime = 20;
                        this.wyrm.attackEntityAsMob(entitylivingbase);
                    }

                    this.wyrm.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
                }
                else if (d0 < this.getFollowDistance() * this.getFollowDistance())
                {
                    double d1 = entitylivingbase.posX - this.wyrm.posX;
                    double d2 = entitylivingbase.getEntityBoundingBox().minY + (double)(entitylivingbase.height / 2.0F) - (this.wyrm.posY + (double)(this.wyrm.height / 2.0F));
                    double d3 = entitylivingbase.posZ - this.wyrm.posZ;

                    if (this.attackTime <= 0)
                    {
                        ++this.attackStep;

                        if (this.attackStep == 1)
                        {
                            this.attackTime = 60;
                        }
                        else if (this.attackStep <= 4)
                        {
                            this.attackTime = 6;
                        }
                        else
                        {
                            this.attackTime = 100;
                            this.attackStep = 0;
                        }

                        if (this.attackStep > 1)
                        {
                            float f = MathHelper.sqrt(MathHelper.sqrt(d0)) * 0.5F;
                            this.wyrm.world.playEvent((EntityPlayer)null, 1018, new BlockPos((int)this.wyrm.posX, (int)this.wyrm.posY, (int)this.wyrm.posZ), 0);

                            for (int i = 0; i < 1; ++i)
                            {
                                EntitySmallFireball entitysmallfireball = new EntitySmallFireball(this.wyrm.world, this.wyrm, d1 + this.wyrm.getRNG().nextGaussian() * (double)f, d2, d3 + this.wyrm.getRNG().nextGaussian() * (double)f);
                                entitysmallfireball.posY = this.wyrm.posY + (double)(this.wyrm.height / 2.0F) + 0.5D;
                                this.wyrm.world.spawnEntity(entitysmallfireball);
                            }
                        }
                    }

                    this.wyrm.getLookHelper().setLookPositionWithEntity(entitylivingbase, 10.0F, 10.0F);
                }
                else
                {
                    this.wyrm.getNavigator().clearPath();
                    this.wyrm.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
                }

                super.updateTask();
            }

            private double getFollowDistance()
            {
                IAttributeInstance iattributeinstance = this.wyrm.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
                return iattributeinstance == null ? 16.0D : iattributeinstance.getAttributeValue();
            }
        }
	
}
