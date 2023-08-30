package dev.rdh.ardhitilts.util.forge;

import com.simibubi.create.AllPackets;
import com.simibubi.create.foundation.networking.SimplePacketBase;

import dev.rdh.ardhitilts.Ardhitilts;

import net.minecraft.world.entity.ai.attributes.Attribute;

import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.util.MavenVersionStringHelper;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.forgespi.language.IModInfo;

import java.util.List;

public class UtilsImpl {
	public static String getVersion() {
		String versionString = "UNKNOWN";

		List<IModInfo> infoList = ModList.get().getModFileById(Ardhitilts.ID).getMods();
		if (infoList.size() > 1) {
			Ardhitilts.LOGGER.error("Multiple mods for ID: " + Ardhitilts.ID);
		}
		for (IModInfo info : infoList) {
			if (info.getModId().equals(Ardhitilts.ID)) {
				versionString = MavenVersionStringHelper.artifactVersionToString(info.getVersion());
				break;
			}
		}
		return versionString;
	}

	public static void registerConfig(ModConfig.Type type, IConfigSpec<?> spec) {
		ModLoadingContext.get().registerConfig(type, spec);
	}

	public static Attribute reach() {
		#if POST_CURRENT_MC_1_20_1
		return ForgeMod.BLOCK_REACH.get();
		#elif PRE_CURRENT_MC_1_19_2
		return ForgeMod.REACH_DISTANCE.get();
		#endif
	}

	public static void sendPacket(SimplePacketBase packet) {
		AllPackets.getChannel().sendToServer(packet);
	}
}
