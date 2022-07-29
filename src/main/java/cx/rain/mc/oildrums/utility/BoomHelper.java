package cx.rain.mc.oildrums.utility;

import cx.rain.mc.oildrums.capability.ExplodingEntity;
import cx.rain.mc.oildrums.capability.ModCapabilities;
import cx.rain.mc.oildrums.network.ModNetworking;
import cx.rain.mc.oildrums.network.packet.CallExplodeC2SPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class BoomHelper {
    public static InteractionResult addBomb(ItemStack stack, Player player, Entity entity, InteractionHand hand) {
        if (hasBomb(entity)) {
            return InteractionResult.FAIL;
        }

        var level = player.getLevel();

        if (level.isClientSide()) {
            ModNetworking.send(new CallExplodeC2SPacket(entity.getId()));
        } else {
            stack.setDamageValue(stack.getDamageValue() + 1);
        }

        return InteractionResult.SUCCESS;
    }

    public static boolean hasBomb(Entity entity) {
        var capOptional = entity.getCapability(ModCapabilities.EXPLODING_ENTITY_CAPABILITY);
        var cap = capOptional.orElse(new ExplodingEntity());
        return cap.willExplode();
    }
}
