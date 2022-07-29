package cx.rain.mc.oildrums.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExplodingEntityProvider implements ICapabilitySerializable<CompoundTag> {
    private final ExplodingEntity entity = new ExplodingEntity();
    private final LazyOptional<IExplodingEntity> entityOptional = LazyOptional.of(() -> entity);

    public void invalidate() {
        entityOptional.invalidate();
    }

    @Override
    public CompoundTag serializeNBT() {
        return entityOptional.orElse(new ExplodingEntity()).serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        entityOptional.orElse(new ExplodingEntity()).deserializeNBT(tag);
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction arg) {
        if (capability == ModCapabilities.EXPLODING_ENTITY_CAPABILITY) {
            return entityOptional.cast();
        }

        return LazyOptional.empty();
    }
}
