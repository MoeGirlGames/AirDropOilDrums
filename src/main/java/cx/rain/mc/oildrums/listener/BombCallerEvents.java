package cx.rain.mc.oildrums.listener;

import cx.rain.mc.oildrums.OilDrums;
import cx.rain.mc.oildrums.capability.ExplodingEntity;
import cx.rain.mc.oildrums.capability.ExplodingEntityProvider;
import cx.rain.mc.oildrums.capability.ModCapabilities;
import cx.rain.mc.oildrums.event.EntityTickEvent;
import cx.rain.mc.oildrums.register.ModItems;
import cx.rain.mc.oildrums.utility.BoomHelper;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityMountEvent;
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
                        BoomHelper.addBomb(item, player, entity, true, 140);
                        event.setCanceled(true);
                    } else if (item.isEmpty() && offHandItem.is(ModItems.BOMB_SETTER)) {
                        BoomHelper.addBomb(offHandItem, player, entity, true, 140);
                        event.setCanceled(true);
                    }

                    if (item.is(ModItems.FIRE_BALL)) {
                        BoomHelper.addBomb(item, player, entity, false, 80);
                        event.setCanceled(true);
                    } else if (item.isEmpty() && offHandItem.is(ModItems.FIRE_BALL)) {
                        BoomHelper.addBomb(offHandItem, player, entity, false, 80);
                        event.setCanceled(true);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent event) {
        var entity = event.getEntity();

        if (entity == null) {
            return;
        }

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

//        if (cap.isTicked()) {
//            cap.setTicked(false);
//            return;
//        } else {
//            cap.setTicked(true);
//        }

        cap.subExplodeRemain();

        if (cap.shouldExplodeNow()) {
            BoomHelper.haBoom(entity, cap);
        }

        if (cap.shouldPlaySound()) {
//            Player player = null;
//            if (cap.hasBombSetter()) {
//                player = entity.level.getPlayerByUUID(cap.getBombSetter());
//            }

            entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                    SoundEvents.NOTE_BLOCK_HAT, SoundSource.NEUTRAL, 1.0f, 0.5f);
        }
    }
}
