package cx.rain.mc.oildrums.entity;

import cx.rain.mc.oildrums.register.ModEntities;
import cx.rain.mc.oildrums.utility.OilDrumType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

public class OilDrumEntity extends Entity {
    protected OilDrumType drumType = OilDrumType.TRIPLE_YELLOW;

//    protected int dropTime = 0;

    public OilDrumEntity(EntityType<? extends OilDrumEntity> entityType, Level level) {
        super(entityType, level);
    }

    /*public OilDrumEntity(EntityType<? extends FallingBlockEntity> entityType, Level level) {
        this(entityType, level, OilDrumType.SINGLE_RED);
    }*/

    public OilDrumEntity(Level level, double x, double y, double z, OilDrumType type) {
        this(ModEntities.OILDRUMS, level);
        this.drumType = type;
        this.setPos(x, y, z);
        double g = level.random.nextDouble() * 6.2831854820251465;
        this.setDeltaMovement(-Math.sin(g) * 0.02, 0.20000000298023224, -Math.cos(g) * 0.02);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    public @NotNull Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    public void tick() {
        super.tick();

        if (!isNoGravity() && !onGround) {
            setDeltaMovement(getDeltaMovement().add(0.0, -0.004, 0.0));
        } else {
            setDeltaMovement(Vec3.ZERO);
        }
        move(MoverType.SELF, getDeltaMovement());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        if (!compound.contains("oildrums")) {
            addAdditionalSaveData(compound);
        }

        var nbt = compound.getCompound("oildrums");

        if (!nbt.contains("type") || !nbt.contains("dropTime")) {
            addAdditionalSaveData(compound);
        }

        var typeString = nbt.getString("type");

        drumType = OilDrumType.fromId(typeString);
//        dropTime = nbt.getInt("dropTime");
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag compound) {
        if (!compound.contains("oildrums")) {
            drumType = OilDrumType.TRIPLE_YELLOW;
        }

        var nbt = compound.getCompound("oildrums");
        nbt.putString("type", getOilDrumType().getId());
//        nbt.putInt("dropTime", dropTime);
    }

    private void explode() {
        if (level.isClientSide()) {
            return;
        }

        level.explode(this, this.getX(), this.getY(0.0625F), this.getZ(), getOilDrumType().getExplodeDistance(), Explosion.BlockInteraction.BREAK);
    }

    public OilDrumType getOilDrumType() {
        return drumType;
    }
}
