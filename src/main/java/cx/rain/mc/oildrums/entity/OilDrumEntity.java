package cx.rain.mc.oildrums.entity;

import cx.rain.mc.oildrums.register.ModEntities;
import cx.rain.mc.oildrums.utility.OilDrumType;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

public class OilDrumEntity extends Entity {
    private OilDrumType drumType;

    public OilDrumEntity(EntityType<Entity> entityType, Level level) {
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
        if (this.onGround) {
            explode();
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {

    }

    private void explode() {
        float radius = (this.drumType == OilDrumType.SUPER_LOUD || this.drumType == OilDrumType.TRIPLE_RED || this.drumType == OilDrumType.SINGLE_RED || this.drumType == OilDrumType.SINGLE_YELLOW || this.drumType == OilDrumType.TRIPLE_YELLOW) ? 5F : 15F;
        this.level.explode(this, this.getX(), this.getY(0.0625F), this.getZ(), radius, Explosion.BlockInteraction.BREAK);
    }
}
