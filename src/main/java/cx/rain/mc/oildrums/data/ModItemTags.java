package cx.rain.mc.oildrums.data;

import cx.rain.mc.oildrums.OilDrums;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> BOMB_SETTERS = ItemTags.create(new ResourceLocation(OilDrums.MODID, "bomb_setters"));

    public static final TagKey<Item> GARLIC = ItemTags.create(new ResourceLocation("nocaet", "flames"));
}
