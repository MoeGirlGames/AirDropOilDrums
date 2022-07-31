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
    public static final ResourceLocation IS_BOMB_KILLED = new ResourceLocation(OilDrums.MODID, "killed_by_bomb");

    @SubscribeEvent
    public static void onRegisterPredicates(RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        Registry.register(Registry.LOOT_CONDITION_TYPE, IS_BOMB_KILLED, BombKilledCondition.BOMB_KILLED_TYPE);
    }
}