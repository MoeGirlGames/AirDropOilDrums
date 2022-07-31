package cx.rain.mc.oildrums.event;

import cx.rain.mc.oildrums.OilDrums;
import cx.rain.mc.oildrums.capability.ExplodingEntity;
import cx.rain.mc.oildrums.capability.ExplodingEntityProvider;
import cx.rain.mc.oildrums.capability.ModCapabilities;
import cx.rain.mc.oildrums.data.ModItemTags;
import cx.rain.mc.oildrums.register.ModItems;
import cx.rain.mc.oildrums.utility.BoomHelper;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityMountEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OilDrums.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BombCallerEvents {

    @SubscribeEvent
    public static void onEntityMount(EntityMountEvent event) {
        if (event.isMounting()) {
            var entity = event.getEntityBeingMounted();
            if (event.getEntityMounting() instanceof Player player) {
                if (!BoomHelper.hasBomb(entity)) {
                    var item = player.getMainHandItem();
                    var offHandItem = player.getOffhandItem();
                    if (item.is(ModItems.BOMB_SETTER)) {
                        BoomHelper.addBomb(item, player, entity, true, 200);
                        event.setCanceled(true);
                    } else if (item.isEmpty() && offHandItem.is(ModItems.BOMB_SETTER)) {
                        BoomHelper.addBomb(offHandItem, player, entity, true, 200);
                        event.setCanceled(true);
                    }

                    if (item.is(ModItems.FIRE_BALL)) {
                        BoomHelper.addBomb(item, player, entity, false, 100);
                        event.setCanceled(true);
                    } else if (item.isEmpty() && offHandItem.is(ModItems.FIRE_BALL)) {
                        BoomHelper.addBomb(offHandItem, player, entity, false, 100);
                        event.setCanceled(true);
                    }
                }
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

        if (event instanceof PlaySoundAtEntityEvent) {
            return;
        }

        var entity = event.getEntity();

        if (entity == null) {
            return;
        }

        if (entity.isRemoved()) {
            return;
        }

        var capOptional = entity.getCapability(ModCapabilities.EXPLODING_ENTITY_CAPABILITY);
        var cap = capOptional.orElse(new ExplodingEntityProvider()
                .getCapability(ModCapabilities.EXPLODING_ENTITY_CAPABILITY)
                .orElse(new ExplodingEntity()));

        if (!cap.willExplode()) {
            return;
        }

        if (event instanceof PlayerEvent) {
            if (cap.isTicked()) {
                cap.setTicked(false);
                return;
            } else {
                cap.setTicked(true);
            }
        }

        cap.subExplodeRemain();

        if (cap.shouldExplodeNow()) {
            BoomHelper.haBoom(entity, cap);
        }

        if (cap.shouldPlaySound()) {
            entity.playSound(SoundEvents.NOTE_BLOCK_HAT, 1.0f, 0.5f);
        }
    }

    @SubscribeEvent
    public static void onBoatTick(BoatTickEvent event) {
        var entity = event.getEntity();

        if (entity.isRemoved()) {
            return;
        }

        var capOptional = event.getEntity().getCapability(ModCapabilities.EXPLODING_ENTITY_CAPABILITY);
        var cap = capOptional.orElse(new ExplodingEntityProvider()
                .getCapability(ModCapabilities.EXPLODING_ENTITY_CAPABILITY)
                .orElse(new ExplodingEntity()));

        if (!cap.willExplode()) {
            return;
        }

        cap.subExplodeRemain();

        if (cap.shouldExplodeNow()) {
            BoomHelper.haBoom(entity, cap);
        }

        if (cap.shouldPlaySound()) {
            entity.playSound(SoundEvents.NOTE_BLOCK_HAT, 1.0f, 0.5f);
        }
    }


}
