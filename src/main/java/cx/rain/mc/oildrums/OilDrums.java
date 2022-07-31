package cx.rain.mc.oildrums;

import cx.rain.mc.oildrums.network.ModNetworking;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(OilDrums.MODID)
public class OilDrums {
    public static final String MODID = "oildrums";
    public static final String NAME = "Oil Drums";
    public static final String VERSION = "1.18.2-1.0.3";

    private Logger logger = LogManager.getLogger(NAME);

    public OilDrums() {
        logger.info("Loading Airdrop OilDrums. Ver: " + VERSION);

        ModNetworking.register();

        logger.info("Ha boom!");
    }
}
