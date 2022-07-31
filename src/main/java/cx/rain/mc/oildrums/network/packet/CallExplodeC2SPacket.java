package cx.rain.mc.oildrums.network.packet;

import cx.rain.mc.oildrums.capability.ExplodingEntity;
import cx.rain.mc.oildrums.capability.ExplodingEntityProvider;
import cx.rain.mc.oildrums.capability.ModCapabilities;
import cx.rain.mc.oildrums.register.ModItems;
import cx.rain.mc.oildrums.utility.BoomHelper;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CallExplodeC2SPacket {
    public int id;
    public ItemStack stack;

    public CallExplodeC2SPacket(int entityId, ItemStack stack) {
        id = entityId;
    }

    public CallExplodeC2SPacket(FriendlyByteBuf buf) {
        id = buf.readInt();
        stack = buf.readItem();
    }

    public void serialize(FriendlyByteBuf buf) {
        buf.writeInt(id);
        buf.writeItem(stack);
    }

    public void handle(Supplier<NetworkEvent.Context> supplier) {
        var context = supplier.get();

        context.enqueueWork(() -> {
            var entity = context.getSender().level.getEntity(id);

            if (entity == null) {
                return;
            }

            if (stack.is(ModItems.FIRE_BALL)) {
                BoomHelper.addBomb(stack, context.getSender(), entity, false, 100);
            } else if (stack.is(ModItems.BOMB_SETTER)) {
                BoomHelper.addBomb(stack, context.getSender(), entity, true, 200);
            }
        });

        context.setPacketHandled(true);
    }
}
