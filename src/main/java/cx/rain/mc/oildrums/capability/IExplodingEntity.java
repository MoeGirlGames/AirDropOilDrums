package cx.rain.mc.oildrums.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.util.INBTSerializable;

public interface IExplodingEntity extends INBTSerializable<CompoundTag> {
    boolean willExplode();

    boolean shouldPlaySound();

    boolean shouldExplodeNow();
    int explodeRemainTicks();
    void subExplodeRemain();

    void setExplode(int ticks);
}
