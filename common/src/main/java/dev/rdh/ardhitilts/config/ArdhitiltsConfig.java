package dev.rdh.ardhitilts.config;

import com.simibubi.create.foundation.config.ConfigBase;
import com.simibubi.create.foundation.config.ui.BaseConfigScreen;
import dev.rdh.ardhitilts.Ardhitilts;
import dev.rdh.ardhitilts.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Nullable;

import static net.minecraftforge.fml.config.ModConfig.Type.*;

public class ArdhitiltsConfig extends ConfigBase {
	public static final ArdhitiltsConfig INSTANCE = new ArdhitiltsConfig();

	@Override
	public String getName() {
		return "client";
	}

	public final ConfigFloat reach = f(0, 0, "reach", Comments.reach);
	public final ConfigBool goggles = b(false, "goggles", Comments.goggles);
	public final ConfigFloat trainMoveDistance = f(24, 0, "trainMoveDistance", Comments.trainMoveDistance);
	public final ConfigFloat flySpeed = f(5, 1, 30, "flySpeed", Comments.flySpeed);

	public final ConfigGroup toggles = group(1, "toggles", Comments.group);
	public final ConfigBool fly = b(false, "fly", Comments.fly);
	public final ConfigBool noFall = b(false, "noFall", Comments.noFall);

	private static class Comments {
		static final String reach = "Reach distance. Adds to your base reach.";
		static final String goggles = "Show goggle tooltips without wearing goggles.";
		static final String trainMoveDistance = "Maximum distance trains can be moved with wrenches.";
		static final String flySpeed = "How fast to fly.";

		static final String group = "Toggles for all the settings. Prefer keybinds.";
		static final String fly = "Fly.";
		static final String noFall = "Disable fall damage.";
	}

	public static void onLoad(ModConfig modConfig) {
		if (INSTANCE.specification == modConfig.getSpec())
			INSTANCE.onLoad();
	}

	public static void onReload(ModConfig modConfig) {
		if (INSTANCE.specification == modConfig.getSpec())
			INSTANCE.onReload();
	}

	public static void register() {
		Pair<ArdhitiltsConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(builder -> {
			ArdhitiltsConfig config = INSTANCE;
			config.registerAll(builder);
			return config;
		});

		ArdhitiltsConfig config = specPair.getLeft();
		config.specification = specPair.getRight();
		Utils.registerConfig(CLIENT, config.specification);
	}

	public static BaseConfigScreen createConfigScreen(Screen parent) {
		BaseConfigScreen.setDefaultActionFor(Ardhitilts.ID, (base) ->
				base.withSpecs(INSTANCE.specification, null, null)
						.withTitles("Settings", "", "")
		);
		return new BaseConfigScreen(parent, Ardhitilts.ID);
	}
	public static BaseConfigScreen createConfigScreen(@Nullable Minecraft mc, Screen parent) {
		return createConfigScreen(parent);
	}
}
