package cx.rain.mc.oildrums.utility;

import cx.rain.mc.oildrums.capability.IExplodingEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.EntityBasedExplosionDamageCalculator;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class BombExplosionDamageCalculator extends EntityBasedExplosionDamageCalculator {
    public final Entity source;
    public final Entity target;

    public BombExplosionDamageCalculator(@Nullable Entity sourceIn, @NotNull Entity targetIn) {
        super(sourceIn);
        source = sourceIn;
        target = targetIn;
    }

    @Override
    public boolean shouldBlockExplode(Explosion explosion, BlockGetter reader, BlockPos pos,
                                      BlockState state, float power) {
        if (source == null) {
            return target.shouldBlockExplode(explosion, reader, pos, state, power);
        }

        return source.shouldBlockExplode(explosion, reader, pos, state, power);
    }

    @Override
    public Optional<Float> getBlockExplosionResistance(Explosion explosion, BlockGetter reader, BlockPos pos,
                                                       BlockState state, FluidState fluid) {
        if (source == null) {
            return super.getBlockExplosionResistance(explosion, reader, pos, state, fluid).map(f ->
                    target.getBlockExplosionResistance(explosion,
                            reader, pos, state, fluid, f));
        }

        return super.getBlockExplosionResistance(explosion, reader, pos, state, fluid).map(f ->
                source.getBlockExplosionResistance(explosion,
                        reader, pos, state, fluid, f));
    }
}
