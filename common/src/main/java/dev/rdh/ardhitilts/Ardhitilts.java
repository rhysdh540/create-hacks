package dev.rdh.ardhitilts;

import dev.rdh.ardhitilts.config.ArdhitiltsConfig;
import dev.rdh.ardhitilts.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ardhitilts {
    public static final String ID = "ardhitilts";
    public static final String NAME = "Ardhitilts";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final String VERSION = Utils.getVersion();

    public static void init() {
        LOGGER.info("Ardhitilts v{}", VERSION);
        ArdhitiltsConfig.register();
    }
}
