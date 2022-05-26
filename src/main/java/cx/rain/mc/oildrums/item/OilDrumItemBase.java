package cx.rain.mc.oildrums.item;

import cx.rain.mc.oildrums.entity.ModEntities;
import cx.rain.mc.oildrums.entity.OilDrumEntity;
import cx.rain.mc.oildrums.utility.OilDrumType;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;

public class OilDrumItemBase extends Item {
    private OilDrumType drumType = null;

    public OilDrumItemBase(OilDrumType type) {
        super(new Properties()
                .setNoRepair()
                .stacksTo(16)
                .tab(CreativeModeTab.TAB_MISC));

        drumType = type;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        var pos = context.getClickedPos();
        var level = context.getLevel();
        var target = level.getBlockState(pos);

        var oilDrums = new OilDrumEntity(ModEntities.OIL_DRUMS.get(), level);

        level.addFreshEntity(oilDrums);

        return super.useOn(context);
    }
}
