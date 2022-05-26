package cx.rain.mc.oildrums.entity;

import cx.rain.mc.oildrums.OilDrums;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, OilDrums.MODID);
    public static final DeferredRegister<Item> ENTITY_EGGS = DeferredRegister.create(ForgeRegistries.ITEMS, OilDrums.MODID);

    public static final RegistryObject<EntityType<OilDrumEntity>> OIL_DRUMS = ENTITIES.register("oil_drums", () -> EntityType.Builder.of(OilDrumEntity::new, MobCategory.MONSTER)
            .setShouldReceiveVelocityUpdates(false)
            // Todo: qyl27: size here.
//            .sized(0.8f, 1)
            .build("oil_drum"));

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
        ENTITY_EGGS.register(bus);
    }
}
