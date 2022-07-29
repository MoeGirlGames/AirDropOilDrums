package cx.rain.mc.oildrums.event;

import cx.rain.mc.oildrums.OilDrums;
import cx.rain.mc.oildrums.capability.ExplodingEntity;
import cx.rain.mc.oildrums.capability.ModCapabilities;
import cx.rain.mc.oildrums.register.ModItems;
import cx.rain.mc.oildrums.utility.BoomHelper;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OilDrums.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BombCallerEvents {
    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getTarget().canRiderInteract()) {
            var player = event.getPlayer();
            var entity = event.getTarget();

            if (player.getItemInHand(event.getHand()).is(ModItems.AIRDROP_CALLER)) {
                var stack = player.getItemInHand(event.getHand());
                BoomHelper.addBomb(stack, player, entity, event.getHand());
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityMount(EntityMountEvent event) {
        if (event.isMounting()) {
            if (BoomHelper.hasBomb(event.getEntityBeingMounted())) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityTick(EntityEvent event) {
        if (event instanceof LivingHurtEvent) {
            return;
        }

        if (event instanceof LivingAttackEvent) {
            return;
        }


        if (event instanceof LivingDeathEvent) {
            return;
        }

        if (event instanceof LivingDamageEvent) {
            return;
        }

        if (event instanceof EntityMountEvent) {
            return;
        }

        var entity = event.getEntity();

        if (entity == null) {
            return;
        }

        var capOptional = entity.getCapability(ModCapabilities.EXPLODING_ENTITY_CAPABILITY);
        var cap = capOptional.orElse(new ExplodingEntity());

        if (!cap.willExplode()) {
            return;
        }

        if (cap.shouldExplodeNow()) {
            entity.level.explode(entity, entity.getX(), entity.getY(), entity.getZ(), 3, Explosion.BlockInteraction.BREAK);

            kill(entity);
        }

        cap.subExplodeRemain();

        if (cap.shouldPlaySound()) {
            entity.playSound(SoundEvents.NOTE_BLOCK_HAT, 1.0f, 0.5f);
        }
    }

    private static void kill(Entity entity) {
        if (!(entity instanceof Player)) {
            if (entity.hasPassenger(e -> true)) {
                for (var passenger : entity.getPassengers()) {
                    kill(passenger);
                }
            }
            entity.kill();
        }
    }
}
