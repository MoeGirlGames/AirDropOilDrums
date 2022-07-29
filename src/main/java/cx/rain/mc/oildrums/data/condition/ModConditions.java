package cx.rain.mc.oildrums.data.condition;

import cx.rain.mc.oildrums.OilDrums;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OilDrums.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConditions {
    public static final ResourceLocation HAS_ITEM_ID = new ResourceLocation(OilDrums.MODID, "has_item");

    @SubscribeEvent
    public static void onRegisterPredicates(RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
//        Registry.register(Registry.LOOT_CONDITION_TYPE, HAS_ITEM_ID, HasItemCondition.HAS_ITEM_TYPE);
    }
}