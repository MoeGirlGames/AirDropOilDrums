package cx.rain.mc.oildrums.data.provider.language;

import cx.rain.mc.oildrums.item.FireBallItem;
import cx.rain.mc.oildrums.register.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageProviderENUS extends LanguageProvider {
    public LanguageProviderENUS(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.BOMB_SETTER, "Bomb setter");
        add(ModItems.FIRE_BALL, "Unstable ball");
        add(FireBallItem.DESC_1, "It will really explode!");
        add(FireBallItem.DESC_2, "But explosion is an art.");

        add(ModItems.FIRE_BALL.getDescriptionId() + ".clue", "There seems to be smoke in the forest?");

        add("itemGroup.oildrums", "Airdrop OilDrums");
    }
}
