package net.examplegroup.examplemod.config;

import com.simibubi.create.foundation.config.ConfigBase;
import com.simibubi.create.foundation.config.ui.BaseConfigScreen;
import net.examplegroup.examplemod.ExampleMod;
import net.examplegroup.examplemod.config.client.CClient;
import net.examplegroup.examplemod.config.common.CCommon;
import net.examplegroup.examplemod.config.server.CServer;
import net.examplegroup.examplemod.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;


import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import static net.minecraftforge.fml.config.ModConfig.Type.*;

public class ExampleConfig {

	@ApiStatus.Internal
	public static final Map<Type, ConfigBase> CONFIGS = new EnumMap<>(Type.class);

	public static CServer server() {
		return (CServer) byType(SERVER);
	}
	public static CClient client() {
		return (CClient) byType(CLIENT);
	}
	public static CCommon common() {
		return (CCommon) byType(COMMON);
	}

	public static @Nullable ConfigBase byType(Type type) {
		return CONFIGS.get(type);
	}

	public static @Nullable ForgeConfigSpec getSpecByType(Type type) {
		ConfigBase config = CONFIGS.get(type);
		return config != null ? config.specification : null;
	}

	private static <T extends ConfigBase> void register(Supplier<T> factory, Type side) {
		Pair<T, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(builder -> {
			T config = factory.get();
			config.registerAll(builder);
			return config;
		});

		T config = specPair.getLeft();
		config.specification = specPair.getRight();
		CONFIGS.put(side, config);
	}

	public static void register() {
		register(CServer::new, SERVER);

		for(var pair : CONFIGS.entrySet())
			Utils.registerConfig(pair.getKey(), pair.getValue().specification);
	}

	public static void onLoad(ModConfig modConfig) {
		for (ConfigBase config : CONFIGS.values())
			if (config.specification == modConfig.getSpec())
				config.onLoad();
	}

	public static void onReload(ModConfig modConfig) {
		for (ConfigBase config : CONFIGS.values())
			if (config.specification == modConfig.getSpec())
				config.onReload();
	}

	public static BaseConfigScreen createConfigScreen(Screen parent) {
		BaseConfigScreen.setDefaultActionFor(ExampleMod.ID, (base) ->
				base.withSpecs(getSpecByType(CLIENT), getSpecByType(COMMON), getSpecByType(SERVER))
						.withTitles("Client Config", "Common Config", "Server Config")
		);
		return new BaseConfigScreen(parent, ExampleMod.ID);
	}
	public static BaseConfigScreen createConfigScreen(@Nullable Minecraft mc, Screen parent) {
		return createConfigScreen(parent);
	}
}
