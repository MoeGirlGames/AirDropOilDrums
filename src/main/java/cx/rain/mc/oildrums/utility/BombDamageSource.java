package cx.rain.mc.oildrums.utility;

import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;

public class BombDamageSource extends IndirectEntityDamageSource {
    public BombDamageSource(String name, Entity entity, Entity setter) {
        super(name, entity, setter);

        setExplosion();
    }

    public static BombDamageSource getBombDamageSource(Entity entity, Entity setter) {
        return new BombDamageSource("bomb", entity, setter);
    }
}
