package cx.rain.mc.oildrums.data.condition;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import cx.rain.mc.oildrums.utility.BombDamageSource;
import net.minecraft.advancements.critereon.DamageSourcePredicate;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.Serializer;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public class BombKilledCondition implements LootItemCondition {
    public static final LootItemConditionType BOMB_KILLED_TYPE =
            new LootItemConditionType(new ConditionSerializer());

    private DamageSourcePredicate source;
    private final boolean isBombKilled;

    protected BombKilledCondition(boolean bombKilled) {
        isBombKilled = bombKilled;
    }

    @Override
    public LootItemConditionType getType() {
        return BOMB_KILLED_TYPE;
    }

    @Override
    public boolean test(LootContext context) {
        var source = context.getParamOrNull(LootContextParams.DAMAGE_SOURCE);
        if (source instanceof BombDamageSource && source.isExplosion()) {
            return isBombKilled;
        }

        return false;
    }

    public static BombKilledCondition.Builder builder(boolean bombKilled) {
        return new BombKilledCondition.Builder(bombKilled);
    }

    public static class Builder implements LootItemCondition.Builder {
        private final boolean isBombKilled;

        public Builder(boolean bombKilled) {
            isBombKilled = bombKilled;
        }

        @Override
        public LootItemCondition build() {
            return new BombKilledCondition(isBombKilled);
        }
    }

    public static class ConditionSerializer implements Serializer<BombKilledCondition> {
        @Override
        public void serialize(JsonObject json, BombKilledCondition value, JsonSerializationContext serializationContext) {
            json.addProperty("isBombKilled", value.isBombKilled);
        }

        @Override
        public BombKilledCondition deserialize(JsonObject json, JsonDeserializationContext serializationContext) {
            return new BombKilledCondition(json.get("isBombKilled").getAsBoolean());
        }
    }
}
