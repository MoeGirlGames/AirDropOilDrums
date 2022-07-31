package cx.rain.mc.oildrums.item;

import cx.rain.mc.oildrums.utility.BoomHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FireBallItem extends Item {
    public static final String DESC_1 = "oildrums.fire_ball.desc.1";
    public static final String DESC_2 = "oildrums.fire_ball.desc.2";

    public FireBallItem() {
        super(new Properties()
                .fireResistant()
                .setNoRepair()
                .stacksTo(1)
                .tab(TabOilDrums.OIL_DRUMS));
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player,
                                                  LivingEntity target, InteractionHand usedHand) {
        BoomHelper.addBomb(stack, player, target, false, 100);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level,
                                List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltipComponents, isAdvanced);

        tooltipComponents.add(new TranslatableComponent(DESC_1).withStyle(ChatFormatting.GRAY));
        tooltipComponents.add(new TranslatableComponent(DESC_2).withStyle(ChatFormatting.GRAY));

    }
}
