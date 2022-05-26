package cx.rain.mc.oildrums.item;

import cx.rain.mc.oildrums.OilDrums;
import cx.rain.mc.oildrums.utility.OilDrumType;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OilDrums.MODID);

    public static final RegistryObject<Item> SINGLE_YELLOW = ITEMS.register("single_yellow", () -> new OilDrumItemBase(OilDrumType.SINGLE_YELLOW));
    public static final RegistryObject<Item> TRIPLE_YELLOW = ITEMS.register("triple_yellow", () -> new OilDrumItemBase(OilDrumType.TRIPLE_YELLOW));
    public static final RegistryObject<Item> SINGLE_RED = ITEMS.register("single_red", () -> new OilDrumItemBase(OilDrumType.SINGLE_RED));
    public static final RegistryObject<Item> TRIPLE_RED = ITEMS.register("single_red", () -> new OilDrumItemBase(OilDrumType.TRIPLE_RED));
    public static final RegistryObject<Item> SUPER_LOUD = ITEMS.register("super_loud", () -> new OilDrumItemBase(OilDrumType.SUPER_LOUD));
    public static final RegistryObject<Item> OIL_DRUM_SET = ITEMS.register("oil_drum_set", () -> new OilDrumItemBase(OilDrumType.OIL_DRUM_SET));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
