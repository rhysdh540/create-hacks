package net.examplegroup.examplemod.fabric;

import net.examplegroup.examplemod.ExampleMod;
import net.examplegroup.examplemod.config.ExampleConfig;
import net.fabricmc.api.ModInitializer;

#if PRE_CURRENT_MC_1_19_2
import net.minecraftforge.api.fml.event.config.ModConfigEvents;
#elif POST_CURRENT_MC_1_20_1
import fuzs.forgeconfigapiport.api.config.v2.ModConfigEvents;
#endif

public class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ModConfigEvents.loading(ExampleMod.ID).register(ExampleConfig::onLoad);
        ModConfigEvents.reloading(ExampleMod.ID).register(ExampleConfig::onReload);
        ExampleMod.init();
        // on fabric, Registrates must be explicitly finalized and registered.
        ExampleMod.REGISTRATE.register();
    }
}
