package cx.rain.mc.oildrums.item;

import cx.rain.mc.oildrums.client.renderer.AirDropCallingRenderer;
import cx.rain.mc.oildrums.network.ModNetworking;
import cx.rain.mc.oildrums.network.packet.CallExplodeC2SPacket;
import cx.rain.mc.oildrums.utility.BoomHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.DeferredWorkQueue;

public class AirDropCallerItem extends Item {
    public AirDropCallerItem() {
        super(new Properties()
                .tab(TabOilDrums.OIL_DRUMS)
                .defaultDurability(8)
                .rarity(Rarity.UNCOMMON));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {


        return super.use(level, player, usedHand);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        return BoomHelper.addBomb(stack, player, target, hand);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.PASS;
    }
}
