package cx.rain.mc.oildrums.data.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generator, String modId, @Nullable ExistingFileHelper exHelper) {
        super(generator, modId, exHelper);
    }

    @Override
    protected void addTags() {
    }
}
