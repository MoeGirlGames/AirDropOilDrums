package cx.rain.mc.oildrums.client.renderer;

import com.mojang.blaze3d.vertex.BufferBuilder;
import cx.rain.mc.oildrums.OilDrums;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderLevelLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OilDrums.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AirDropCallingRenderer {
    protected int windowWidth = 0;
    protected int windowHeight = 0;

    public AirDropCallingRenderer() {

    }

    @SubscribeEvent
    public static void onModelRegistry(ModelRegistryEvent event) {

    }

    @SubscribeEvent
    public static void onRenderLevelLast(RenderLevelLastEvent event) {

    }

    public void render(BlockPos pos, Level level) {
        if (!level.isLoaded(pos)) {
            return;
        }

        var mc = Minecraft.getInstance();
        var mainWindow = mc.getWindow();
        var width = mainWindow.getWidth();
        var height = mainWindow.getHeight();
        if (width != windowWidth || height != windowHeight) {
            windowWidth = width;
            windowHeight = height;
//            shaders.createBindFramebuffers(width, height);
        }

        var bufferBuilder = new BufferBuilder(256);

    }
}
