package cx.rain.mc.oildrums.data.condition;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

// Todo: qyl27: It should check player has item. But context not contains Player.
/*
public class HasItemCondition implements LootItemCondition {
    public static final LootItemConditionType HAS_ITEM_TYPE =
            new LootItemConditionType(new ConditionSerializer());

    private final ResourceLocation toCheckItem;
    private final Player toCheckPlayer;

    protected HasItemCondition(ResourceLocation item) {
        toCheckItem = item;
    }

    @Override
    public LootItemConditionType getType() {
        return HAS_ITEM_TYPE;
    }

    @Override
    public boolean test(LootContext context) {
        if ()
    }

    public static HasItemCondition.Builder builder(ResourceLocation item) {
        return new HasItemCondition.Builder(item);
    }

    public static class Builder implements LootItemCondition.Builder {
        private final ResourceLocation itemToCheck;

        public Builder(ResourceLocation item) {
            itemToCheck = item;
        }

        @Override
        public LootItemCondition build() {
            return new HasItemCondition(itemToCheck);
        }
    }

    public static class ConditionSerializer implements Serializer<HasItemCondition> {
        @Override
        public void serialize(JsonObject json, HasItemCondition value, JsonSerializationContext serializationContext) {
            json.addProperty("isEven", value.even);
        }

        @Override
        public HasItemCondition deserialize(JsonObject json, JsonDeserializationContext serializationContext) {
            return new HasItemCondition(json.get("isEven").getAsBoolean());
        }
    }
}
 */
