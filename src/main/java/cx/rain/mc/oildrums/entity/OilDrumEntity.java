package cx.rain.mc.oildrums.entity;

import cx.rain.mc.oildrums.utility.OilDrumType;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class OilDrumEntity extends FallingBlockEntity {
    private OilDrumType drumType = null;

    public OilDrumEntity(EntityType<? extends FallingBlockEntity> type, Level level) {
        super(type, level);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
