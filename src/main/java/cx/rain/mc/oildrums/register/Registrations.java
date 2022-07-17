package cx.rain.mc.oildrums.register;

import cx.rain.mc.oildrums.OilDrums;
import cx.rain.mc.oildrums.entity.OilDrumEntity;
import cx.rain.mc.oildrums.item.OilDrumItemBase;
import cx.rain.mc.oildrums.utility.OilDrumType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = OilDrums.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class Registrations {

	@SubscribeEvent
	public static void registerItems(@Nonnull RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> reg = event.getRegistry();

		reg.register(new OilDrumItemBase(OilDrumType.SINGLE_YELLOW).setRegistryName("single_yellow"));
		reg.register(new OilDrumItemBase(OilDrumType.TRIPLE_YELLOW).setRegistryName("triple_yellow"));
		reg.register(new OilDrumItemBase(OilDrumType.SINGLE_RED).setRegistryName("single_red"));
		reg.register(new OilDrumItemBase(OilDrumType.TRIPLE_RED).setRegistryName("triple_red"));
		reg.register(new OilDrumItemBase(OilDrumType.SUPER_LOUD).setRegistryName("super_loud"));
		reg.register(new OilDrumItemBase(OilDrumType.OIL_DRUM_SET).setRegistryName("oil_drum_set"));

	}

	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
		final IForgeRegistry<EntityType<?>> reg = event.getRegistry();
		reg.register(EntityType.Builder.of(OilDrumEntity::new, MobCategory.MISC).sized(0.8F, 1.0F).build("oildrums").setRegistryName("oildrums"));
	}
}

