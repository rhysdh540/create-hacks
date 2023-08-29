package net.examplegroup.examplemod.util;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Path;

public class Utils {
	@ExpectPlatform
	public static String getVersion() {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static boolean isDevEnv() {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static void registerCommand(LiteralArgumentBuilder<CommandSourceStack> command) {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static Path configDir() {
		throw new AssertionError();
	}
}
