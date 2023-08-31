package dev.rdh.ardhitilts.util.fabric;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;

import com.simibubi.create.AllPackets;
import com.simibubi.create.foundation.networking.SimplePacketBase;

import dev.rdh.ardhitilts.Ardhitilts;

import net.fabricmc.loader.api.FabricLoader;

import net.minecraft.world.entity.ai.attributes.Attribute;

#if PRE_CURRENT_MC_1_19_2
import net.minecraftforge.api.ModLoadingContext;
#elif POST_CURRENT_MC_1_20_1
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
#endif
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class UtilsImpl {
	public static String getVersion() {
		return FabricLoader.getInstance()
				.getModContainer(Ardhitilts.ID)
				.orElseThrow()
				.getMetadata()
				.getVersion()
				.getFriendlyString();
	}

	public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
		#if PRE_CURRENT_MC_1_19_2
		ModLoadingContext.registerConfig(Ardhitilts.ID, type, spec);
		#elif POST_CURRENT_MC_1_20_1
		ForgeConfigRegistry.INSTANCE.register(Ardhitilts.ID, type, spec);
		#endif
	}

	public static Attribute reach() {
		return ReachEntityAttributes.REACH;
	}

	public static void sendPacket(SimplePacketBase packet) {
		AllPackets.getChannel().sendToServer(packet);
	}
}
