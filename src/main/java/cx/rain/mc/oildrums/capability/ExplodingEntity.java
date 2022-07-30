package cx.rain.mc.oildrums.capability;

import net.minecraft.nbt.CompoundTag;

public class ExplodingEntity implements IExplodingEntity {
    public static final String REMAIN_TICKS_TAG_NAME = "explodeRemain";
    public static final String LAST_TICKED_TAG_NAME = "lastTicked";

    private int explodeRemain = -1;
    private boolean isTicked = false;

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
    public boolean isTicked() {
        return isTicked;
    }

    @Override
    public void setTicked(boolean ticked) {
        isTicked = ticked;
    }

    @Override
    public void setExplode(int ticks) {
        explodeRemain = ticks;
    }

    @Override
    public CompoundTag serializeNBT() {
        var nbt = new CompoundTag();
        nbt.putInt(REMAIN_TICKS_TAG_NAME, explodeRemain);
        nbt.putBoolean(LAST_TICKED_TAG_NAME, isTicked);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        if (tag.contains(REMAIN_TICKS_TAG_NAME)) {
            explodeRemain = tag.getInt(REMAIN_TICKS_TAG_NAME);
        }

        if (tag.contains(LAST_TICKED_TAG_NAME)) {
            isTicked = tag.getBoolean(LAST_TICKED_TAG_NAME);
        }
    }
}
