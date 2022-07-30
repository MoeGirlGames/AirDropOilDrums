package cx.rain.mc.oildrums.item;

import cx.rain.mc.oildrums.utility.BoomHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class BombSetterItem extends Item {
    public BombSetterItem() {
        super(new Properties()
                .tab(TabOilDrums.OIL_DRUMS)
                .defaultDurability(7)
                .rarity(Rarity.UNCOMMON)
                .setNoRepair());
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        stack = BoomHelper.addBomb(stack, player, target);
        return InteractionResult.SUCCESS;
    }
}
