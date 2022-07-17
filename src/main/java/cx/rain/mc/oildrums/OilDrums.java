package cx.rain.mc.oildrums;

import cx.rain.mc.oildrums.register.ModEntities;
import cx.rain.mc.oildrums.register.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(OilDrums.MODID)
public class OilDrums {
    public static final String MODID = "oildrums";
    public static final String NAME = "Oil Drums";

    private Logger logger = LogManager.getLogger(NAME);

    public OilDrums() {
        logger.info("Ha boom!");
    }
}
