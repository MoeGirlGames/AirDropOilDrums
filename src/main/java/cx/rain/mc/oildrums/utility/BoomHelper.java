package cx.rain.mc.oildrums.utility;

import cx.rain.mc.oildrums.capability.ExplodingEntity;
import cx.rain.mc.oildrums.capability.ExplodingEntityProvider;
import cx.rain.mc.oildrums.capability.IExplodingEntity;
import cx.rain.mc.oildrums.capability.ModCapabilities;
import cx.rain.mc.oildrums.network.ModNetworking;
import cx.rain.mc.oildrums.network.packet.CallExplodeC2SPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;

public class BoomHelper {

    public static ItemStack addBomb(ItemStack stack, Player player, Entity entity, boolean damage, int timeout) {
        if (hasBomb(entity)) {
            return stack;
        }

        var level = player.getLevel();

        if (level.isClientSide()) {
//            ModNetworking.send(new CallExplodeC2SPacket(entity.getId(), stack));
        } else {
            var capOptional = entity.getCapability(ModCapabilities.EXPLODING_ENTITY_CAPABILITY);
            var cap = capOptional.orElse(new ExplodingEntityProvider()
                    .getCapability(ModCapabilities.EXPLODING_ENTITY_CAPABILITY)
                    .orElse(new ExplodingEntity()));
            cap.setExplode(timeout, player.getUUID());

            if (damage && !player.isCreative()) {
                stack.setDamageValue(stack.getDamageValue() + 1);

                if (stack.getMaxDamage() >= stack.getDamageValue()) {
                    stack = ItemStack.EMPTY;
                }
            }
        }

        return stack;
    }

    public static boolean hasBomb(Entity entity) {
        var capOptional = entity.getCapability(ModCapabilities.EXPLODING_ENTITY_CAPABILITY);
        var cap = capOptional.orElse(new ExplodingEntity());
        return cap.willExplode();
    }

    public static void haBoom(Entity entity, IExplodingEntity exp) {
        BombDamageSource source = null;
        Player player = null;

        if (exp.hasBombSetter()) {
            player = entity.level.getPlayerByUUID(exp.getBombSetter());
            source = BombDamageSource.getBombDamageSource(player);
        }

        entity.level.explode(entity, source, new BombExplosionDamageCalculator(player, entity),
                entity.getX(), entity.getY(), entity.getZ(), 3, false, Explosion.BlockInteraction.BREAK);

        exp.setExplode(-1, null);

        if (entity.isAlive()) {
            hurt(entity, player);
        }
    }

    private static void hurt(Entity entity, Player player) {
        if (!(entity instanceof Player)) {
//            if (entity.hasPassenger(e -> true)) {
//                for (var passenger : entity.getPassengers()) {
//                    kill(passenger);
//                }
//            }
            entity.hurt(BombDamageSource.getBombDamageSource(player), 10.0f);
        }
    }
}
