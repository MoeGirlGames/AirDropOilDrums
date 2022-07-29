package cx.rain.mc.oildrums.event;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityEvent;

public class BoatTickEvent extends EntityEvent {
    public BoatTickEvent(Entity entity) {
        super(entity);
    }
}
