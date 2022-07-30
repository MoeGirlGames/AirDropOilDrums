package cx.rain.mc.oildrums.register;

import cx.rain.mc.oildrums.OilDrums;
import cx.rain.mc.oildrums.entity.OilDrumEntity;
import cx.rain.mc.oildrums.item.BombSetterItem;
import cx.rain.mc.oildrums.item.FireBallItem;
import cx.rain.mc.oildrums.item.OilDrumItemBase;
import cx.rain.mc.oildrums.utility.OilDrumType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
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

		registerOilDrumsItems(reg);

		reg.register(new BombSetterItem().setRegistryName("bomb_setter"));
		reg.register(new FireBallItem().setRegistryName("fire_ball"));
	}

	@SubscribeEvent
	public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
		final IForgeRegistry<EntityType<?>> reg = event.getRegistry();

		reg.register(EntityType.Builder
				.<OilDrumEntity>of(OilDrumEntity::new, MobCategory.MISC)
				.sized(0.8F, 1.0F)
				.build("oildrums")
				.setRegistryName("oildrums"));
	}

	private static void registerOilDrumsItems(IForgeRegistry<Item> registry) {
		for (var value :
				OilDrumType.values()) {
			registry.register(new OilDrumItemBase(value).setRegistryName(value.getId()));
		}
	}
}

