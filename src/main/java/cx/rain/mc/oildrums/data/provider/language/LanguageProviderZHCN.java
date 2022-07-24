package cx.rain.mc.oildrums.data.provider.language;

import cx.rain.mc.oildrums.register.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageProviderZHCN extends LanguageProvider {
    public LanguageProviderZHCN(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.AIRDROP_CALLER, "空降信号发生器");

    }
}
