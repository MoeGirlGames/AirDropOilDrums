package cx.rain.mc.oildrums.data.provider.language;

import cx.rain.mc.oildrums.item.FireBallItem;
import cx.rain.mc.oildrums.register.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageProviderZHCN extends LanguageProvider {
    public LanguageProviderZHCN(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    @Override
    protected void addTranslations() {
        add(ModItems.AIRDROP_CALLER, "炸弹放置器");
        add(ModItems.FIRE_BALL, "会爆炸的球");
        add(FireBallItem.DESC_1, "真的会爆炸！");
        add(FireBallItem.DESC_2, "但爆炸就是艺术");

        add(ModItems.FIRE_BALL.getDescriptionId() + ".clue", "森林里面似乎有冒烟的地方？");

        add("itemGroup.oildrums", "空降油桶");
    }
}
