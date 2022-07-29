package cx.rain.mc.oildrums.network;

import cx.rain.mc.oildrums.OilDrums;
import cx.rain.mc.oildrums.network.packet.CallExplodeC2SPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModNetworking {
    private static int id;

    public static synchronized int nextId() {
        return id++;
    }

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(OilDrums.MODID, "network"),
            () -> OilDrums.VERSION,
            (ver) -> ver.equals(OilDrums.VERSION),
            (ver) -> ver.equals(OilDrums.VERSION));

    public static void register() {
        CHANNEL.registerMessage(nextId(),
                CallExplodeC2SPacket.class,
                CallExplodeC2SPacket::serialize,
                CallExplodeC2SPacket::new,
                CallExplodeC2SPacket::handle);
    }

    public static void send(Object message) {
        CHANNEL.sendToServer(message);
    }

    public static void send(Object message, Player player) {
        CHANNEL.sendTo(message, ((ServerPlayer) player).connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }
}
