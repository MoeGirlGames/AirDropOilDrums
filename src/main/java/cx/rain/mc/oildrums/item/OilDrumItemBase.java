package cx.rain.mc.oildrums.item;

import cx.rain.mc.oildrums.entity.OilDrumEntity;
import cx.rain.mc.oildrums.register.ModEntities;
import cx.rain.mc.oildrums.utility.OilDrumType;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

public class OilDrumItemBase extends Item {
    private OilDrumType drumType;

    public OilDrumItemBase(OilDrumType type) {
        super(new Properties()
                .setNoRepair()
                .stacksTo(16)
                .tab(CreativeModeTab.TAB_MISC));

        drumType = type;
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        var pos = context.getClickedPos();
        var level = context.getLevel();

        var oilDrums = new OilDrumEntity(level, pos.getX(), pos.getY(), pos.getZ(), drumType);

        level.addFreshEntity(oilDrums);

        return super.useOn(context);
    }
}
