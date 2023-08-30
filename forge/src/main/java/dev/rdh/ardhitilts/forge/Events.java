package dev.rdh.ardhitilts.forge;

import dev.rdh.ardhitilts.Ardhitilts;
import dev.rdh.ardhitilts.config.ArdhitiltsConfig;
import dev.rdh.ardhitilts.hack.FlyHack;
import dev.rdh.ardhitilts.hack.NoFall;
import dev.rdh.ardhitilts.registry.Keybinds;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;

public abstract class Events {

	@EventBusSubscriber(modid = Ardhitilts.ID, bus = Bus.MOD, value = Dist.CLIENT)
	public static abstract class ClientModBusEvents {
		@SubscribeEvent
		static void onLoadComplete(FMLLoadCompleteEvent event) {
			ModContainer container = ModList.get()
					.getModContainerById(Ardhitilts.ID)
					.orElseThrow(() -> new IllegalStateException("Ardhitilts mod container missing on LoadComplete"));
			container.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class,
					() -> new ConfigScreenHandler.ConfigScreenFactory(ArdhitiltsConfig::createConfigScreen));
		}

		@SubscribeEvent
		public static void onKeyRegister(RegisterKeyMappingsEvent event) {
			event.register(Keybinds.toggleFly);
			event.register(Keybinds.toggleNoFall);
		}
	}

	@EventBusSubscriber(modid = Ardhitilts.ID, value = Dist.CLIENT)
	public static abstract class ClientForgeEvents {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.Key event) {
			if (Keybinds.toggleFly.consumeClick()) {
				ArdhitiltsConfig.INSTANCE.fly.set(!ArdhitiltsConfig.INSTANCE.fly.get());
			} else if (Keybinds.toggleNoFall.consumeClick()) {
				ArdhitiltsConfig.INSTANCE.noFall.set(!ArdhitiltsConfig.INSTANCE.noFall.get());
			}
		}

		@SubscribeEvent
		public static void onClientTick(ClientTickEvent event) {
			FlyHack.performFly();
			NoFall.breakFall();
		}
	}
}
