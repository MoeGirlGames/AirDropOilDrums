package cx.rain.mc.oildrums.mixin;

import cx.rain.mc.oildrums.event.BoatTickEvent;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Boat.class)
public abstract class BoatExplosionMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    private void afterTick(CallbackInfo ci) {
        MinecraftForge.EVENT_BUS.post(new BoatTickEvent((Boat) (Object) this));
    }
}
