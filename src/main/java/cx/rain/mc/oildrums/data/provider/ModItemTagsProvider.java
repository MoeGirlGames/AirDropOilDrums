package cx.rain.mc.oildrums.data.provider;

import cx.rain.mc.oildrums.data.ModItemTags;
import cx.rain.mc.oildrums.register.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider provider, String modId, @Nullable ExistingFileHelper exHelper) {
        super(generator, provider, modId, exHelper);
    }

    @Override
    protected void addTags() {
        tag(ModItemTags.BOMB_SETTERS).add(ModItems.BOMB_SETTER, ModItems.FIRE_BALL);

        tag(ModItemTags.GARLIC).add(ModItems.FIRE_BALL);
    }
}
