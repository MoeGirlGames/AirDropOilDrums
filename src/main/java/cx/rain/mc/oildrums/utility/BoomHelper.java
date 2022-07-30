package cx.rain.mc.oildrums.utility;

import cx.rain.mc.oildrums.capability.ExplodingEntity;
import cx.rain.mc.oildrums.capability.ExplodingEntityProvider;
import cx.rain.mc.oildrums.capability.IExplodingEntity;
import cx.rain.mc.oildrums.capability.ModCapabilities;
import cx.rain.mc.oildrums.network.ModNetworking;
import cx.rain.mc.oildrums.network.packet.CallExplodeC2SPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;

public class BoomHelper {
    public static ItemStack addBomb(ItemStack stack, Player player, Entity entity) {
        if (hasBomb(entity)) {
            return stack;
        }

        var level = player.getLevel();

        if (level.isClientSide()) {
            ModNetworking.send(new CallExplodeC2SPacket(entity.getId()));
        } else {
            var capOptional = entity.getCapability(ModCapabilities.EXPLODING_ENTITY_CAPABILITY);
            var cap = capOptional.orElse(new ExplodingEntityProvider()
                    .getCapability(ModCapabilities.EXPLODING_ENTITY_CAPABILITY)
                    .orElse(new ExplodingEntity()));
            cap.setExplode(200);

            if (!player.isCreative()) {
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

    }


}
