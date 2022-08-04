package cx.rain.mc.oildrums.event;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.Cancelable;

@Cancelable
public class EntityTickEvent extends EntityEvent {
    public EntityTickEvent(Entity entity) {
        super(entity);
    }
}
