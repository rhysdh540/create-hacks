package dev.rdh.ardhitilts.fabric;

import dev.rdh.ardhitilts.Ardhitilts;
import dev.rdh.ardhitilts.config.ArdhitiltsConfig;
import dev.rdh.ardhitilts.hack.FlyHack;
import dev.rdh.ardhitilts.hack.NoFall;
import dev.rdh.ardhitilts.registry.Keybinds;
import io.github.fabricators_of_create.porting_lib.event.client.KeyInputCallback;
import net.fabricmc.api.ClientModInitializer;

#if PRE_CURRENT_MC_1_19_2
import net.minecraftforge.api.fml.event.config.ModConfigEvents;
#elif POST_CURRENT_MC_1_20_1
import fuzs.forgeconfigapiport.api.config.v2.ModConfigEvents;
#endif
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class ArdhitiltsFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModConfigEvents.loading(Ardhitilts.ID).register(ArdhitiltsConfig::onLoad);
        ModConfigEvents.reloading(Ardhitilts.ID).register(ArdhitiltsConfig::onReload);
        KeyBindingHelper.registerKeyBinding(Keybinds.toggleFly);
        KeyBindingHelper.registerKeyBinding(Keybinds.toggleNoFall);
        registerEvents();

        Ardhitilts.init();
    }

    private static void registerEvents() {
        ClientTickEvents.START_CLIENT_TICK.register(client -> {
            FlyHack.performFly();
            NoFall.breakFall();
        });

        KeyInputCallback.EVENT.register((key, scancode, action, mods) -> {
            if (Keybinds.toggleFly.consumeClick()) {
                ArdhitiltsConfig.INSTANCE.fly.set(!ArdhitiltsConfig.INSTANCE.fly.get());
            } else if (Keybinds.toggleNoFall.consumeClick()) {
                ArdhitiltsConfig.INSTANCE.noFall.set(!ArdhitiltsConfig.INSTANCE.noFall.get());
            }
        });
    }
}
