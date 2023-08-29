package net.examplegroup.examplemod;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.examplegroup.examplemod.multiloader.Loader;
import net.examplegroup.examplemod.util.Utils;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod {
    public static final String ID = "examplemod";
    public static final String NAME = "Example Mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final String VERSION = Utils.getVersion();
    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ExampleMod.ID);

    public static void init() {
        LOGGER.info("{} v{} initializing! Create version: {} on platform: {}", NAME, VERSION, Create.VERSION, Loader.CURRENT);
        if(Utils.isDevEnv())
            LOGGER.info("Running in development environment!");
        ExampleBlocks.init();
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }
}
