package dev.rdh.ardhitilts.util;

import com.simibubi.create.foundation.networking.SimplePacketBase;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.ai.attributes.Attribute;

import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class Utils {
	@ExpectPlatform
	public static String getVersion() {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static void sendPacket(SimplePacketBase packet) {
		throw new AssertionError();
	}

	@ExpectPlatform
	public static Attribute reach() {
		throw new AssertionError();
	}
}
