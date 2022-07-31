package cx.rain.mc.oildrums.utility;

import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.entity.Entity;

public class BombDamageSource extends EntityDamageSource {
    public BombDamageSource(String name, Entity setter) {
        super(name, setter);

        setExplosion();
    }

    public static BombDamageSource getBombDamageSource(Entity setter) {
        return new BombDamageSource("bomb", setter);
    }
}
