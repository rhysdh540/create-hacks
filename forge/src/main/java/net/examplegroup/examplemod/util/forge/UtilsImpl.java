package net.examplegroup.examplemod.util.forge;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.examplegroup.examplemod.ExampleMod;
import net.minecraft.commands.CommandSourceStack;
import net.minecraftforge.common.util.MavenVersionStringHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.forgespi.language.IModInfo;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("UnstableApiUsage")
public class UtilsImpl {
	public static String getVersion() {
		String versionString = "UNKNOWN";

		List<IModInfo> infoList = ModList.get().getModFileById(ExampleMod.ID).getMods();
		if (infoList.size() > 1) {
			ExampleMod.LOGGER.error("Multiple mods for ID: " + ExampleMod.ID);
		}
		for (IModInfo info : infoList) {
			if (info.getModId().equals(ExampleMod.ID)) {
				versionString = MavenVersionStringHelper.artifactVersionToString(info.getVersion());
				break;
			}
		}
		return versionString;
	}

	public static boolean isDevEnv() {
		return !FMLLoader.isProduction();
	}

	public static Path configDir() {
		return FMLPaths.CONFIGDIR.get();
	}

	public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
		ModLoadingContext.get().registerConfig(type, spec);
	}

	public static Set<LiteralArgumentBuilder<CommandSourceStack>> commands = new HashSet<>();

	public static void registerCommand(LiteralArgumentBuilder<CommandSourceStack> command) {
		commands.add(command);
	}
}
