package net.examplegroup.examplemod.forge;

import net.examplegroup.examplemod.ExampleMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExampleMod.ID)
public class ExampleModForge {
    public ExampleModForge() {
        // registrate must be given the mod event bus on forge before registration
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ExampleMod.REGISTRATE.registerEventListeners(eventBus);
        ExampleMod.init();
    }
}
