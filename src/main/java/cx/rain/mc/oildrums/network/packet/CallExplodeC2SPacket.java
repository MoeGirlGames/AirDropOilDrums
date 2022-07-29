package cx.rain.mc.oildrums.network.packet;

import cx.rain.mc.oildrums.capability.ExplodingEntity;
import cx.rain.mc.oildrums.capability.ModCapabilities;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class CallExplodeC2SPacket {
    public int id;

    public CallExplodeC2SPacket(int entityId) {
        id = entityId;
    }

    public CallExplodeC2SPacket(FriendlyByteBuf buf) {
        id = buf.readInt();
    }

    public void serialize(FriendlyByteBuf buf) {
        buf.writeInt(id);
    }

    public void handle(Supplier<NetworkEvent.Context> supplier) {
        var context = supplier.get();

        context.enqueueWork(() -> {
            var entity = context.getSender().level.getEntity(id);

            if (entity == null) {
                return;
            }

            var capOptional = entity.getCapability(ModCapabilities.EXPLODING_ENTITY_CAPABILITY);
            var cap = capOptional.orElse(new ExplodingEntity());

            cap.setExplode(120);
        });

        context.setPacketHandled(true);
    }
}
