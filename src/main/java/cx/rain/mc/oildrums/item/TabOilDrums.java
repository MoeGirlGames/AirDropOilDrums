package cx.rain.mc.oildrums.item;

import cx.rain.mc.oildrums.register.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TabOilDrums extends CreativeModeTab {
    public static final CreativeModeTab OIL_DRUMS = new TabOilDrums();

    public TabOilDrums() {
        super("oildrums");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ModItems.TRIPLE_YELLOW);
    }
}
