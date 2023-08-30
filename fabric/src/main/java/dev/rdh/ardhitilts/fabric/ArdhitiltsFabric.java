package dev.rdh.ardhitilts.fabric;

import dev.rdh.ardhitilts.Ardhitilts;
import dev.rdh.ardhitilts.config.ArdhitiltsConfig;
import dev.rdh.ardhitilts.registry.Keybinds;
import net.fabricmc.api.ClientModInitializer;

#if PRE_CURRENT_MC_1_19_2
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraftforge.api.fml.event.config.ModConfigEvents;
#elif POST_CURRENT_MC_1_20_1
import fuzs.forgeconfigapiport.api.config.v2.ModConfigEvents;
#endif

public class ArdhitiltsFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModConfigEvents.loading(Ardhitilts.ID).register(ArdhitiltsConfig::onLoad);
        ModConfigEvents.reloading(Ardhitilts.ID).register(ArdhitiltsConfig::onReload);
        KeyBindingHelper.registerKeyBinding(Keybinds.toggleFly);
        KeyBindingHelper.registerKeyBinding(Keybinds.toggleNoFall);

        Ardhitilts.init();
    }
}
