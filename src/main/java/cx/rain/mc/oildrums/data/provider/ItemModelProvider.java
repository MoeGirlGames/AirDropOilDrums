package cx.rain.mc.oildrums.data.provider;

import cx.rain.mc.oildrums.register.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    public static final ResourceLocation GENERATED = new ResourceLocation("item/generated");
    public static final ResourceLocation HANDHELD = new ResourceLocation("item/handheld");

    public ItemModelProvider(DataGenerator generator, String modId, ExistingFileHelper exHelper) {
        super(generator, modId, exHelper);
    }

    protected ModelFile getModel(ResourceLocation loc) {
        return new ModelFile.UncheckedModelFile(loc);
    }

    @Override
    protected void registerModels() {
//        getBuilder(ModItems.AIRDROP_CALLER.getRegistryName().getPath())
//                .parent(getModel(HANDHELD))
//                .texture("layer0", new ResourceLocation(modid, "item/airdrop_caller"));
//        getBuilder(ModItems.FIRE_BALL.getRegistryName().getPath())
//                .parent(getModel(HANDHELD))
//                .texture("layer0", new ResourceLocation(modid, "item/fire_ball"));


    }
}
