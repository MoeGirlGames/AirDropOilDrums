package cx.rain.mc.oildrums.mixin;

import cx.rain.mc.oildrums.event.EntityTickEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.decoration.Painting;
import net.minecraft.world.entity.vehicle.*;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class BoatExplosionMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void afterTick(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        if (entity instanceof LivingEntity
                || entity instanceof Boat
                || entity instanceof Minecart
                || entity instanceof MinecartTNT
                || entity instanceof MinecartFurnace
                || entity instanceof AbstractMinecartContainer
                || entity instanceof Painting
                || entity instanceof ItemFrame) {


            var result = MinecraftForge.EVENT_BUS.post(new EntityTickEvent((Entity) (Object) this));
            if (result) {
                ci.cancel();
            }
        }
    }
}
