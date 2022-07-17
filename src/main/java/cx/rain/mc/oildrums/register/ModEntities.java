package cx.rain.mc.oildrums.register;

import cx.rain.mc.oildrums.entity.OilDrumEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.ObjectHolder;

public class ModEntities {
    @ObjectHolder("oildrums:oildrums")
    public static EntityType<OilDrumEntity> OILDRUMS;
}
