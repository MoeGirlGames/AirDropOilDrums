package cx.rain.mc.oildrums.capability;

import net.minecraft.nbt.CompoundTag;

public class ExplodingEntity implements IExplodingEntity {
    public static final String REMAIN_TICKS_TAG_NAME = "explodeRemain";

    private int explodeRemain = -1;

    @Override
    public boolean willExplode() {
        return explodeRemain >= 0;
    }

    @Override
    public boolean shouldPlaySound() {
        return explodeRemain % 15 == 0;
    }

    @Override
    public boolean shouldExplodeNow() {
        return explodeRemain == 0;
    }

    @Override
    public int explodeRemainTicks() {
        return explodeRemain;
    }

    @Override
    public void subExplodeRemain() {
        explodeRemain -= 1;
    }

    @Override
    public void setExplode(int ticks) {
        explodeRemain = ticks;
    }

    @Override
    public CompoundTag serializeNBT() {
        var nbt = new CompoundTag();
        nbt.putInt(REMAIN_TICKS_TAG_NAME, explodeRemain);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        if (tag.contains(REMAIN_TICKS_TAG_NAME)) {
            explodeRemain = tag.getInt(REMAIN_TICKS_TAG_NAME);
        }
    }
}
