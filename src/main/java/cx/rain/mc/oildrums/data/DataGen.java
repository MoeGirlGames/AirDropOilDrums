package cx.rain.mc.oildrums.data;

import cx.rain.mc.oildrums.OilDrums;
import cx.rain.mc.oildrums.data.provider.ItemModelProvider;
import cx.rain.mc.oildrums.data.provider.language.LanguageProviderENUS;
import cx.rain.mc.oildrums.data.provider.language.LanguageProviderZHCN;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = OilDrums.MODID)
public class DataGen {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var exHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(new ItemModelProvider(generator, OilDrums.MODID, exHelper));

            generator.addProvider(new LanguageProviderZHCN(generator, OilDrums.MODID, "zh_cn"));
            generator.addProvider(new LanguageProviderENUS(generator, OilDrums.MODID, "en_us"));
        }

        if (event.includeServer()) {
        }
    }
}
