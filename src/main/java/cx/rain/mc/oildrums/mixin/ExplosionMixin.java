package cx.rain.mc.oildrums.mixin;

import cx.rain.mc.oildrums.entity.OilDrumEntity;
import cx.rain.mc.oildrums.register.ModEntities;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(Explosion.class)
public abstract class ExplosionMixin {
    @Shadow
    @Final
    @Nullable
    private Entity source;

    @Shadow
    @Final
    private Level level;

    @Shadow
    @Final
    private double x;

    @Shadow
    @Final
    private double y;

    @Shadow
    @Final
    private double z;

    @Inject(method = "finalizeExplosion", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;playLocalSound(DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V"))
    private void onOilDrumsExplosion(CallbackInfo ci) {
        if (source != null) {
            if (source instanceof OilDrumEntity) {
                var oilDrum = (OilDrumEntity) source;
                if (level.isClientSide) {
                    level.playLocalSound(x, y, z, SoundEvents.GENERIC_EXPLODE,
                            SoundSource.BLOCKS, oilDrum.getOilDrumType().getSoundVolume(),
                            oilDrum.getOilDrumType().getSoundDistance(), true);
                }
                ci.cancel();
            }
        }
    }
}
