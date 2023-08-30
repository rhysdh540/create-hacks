package dev.rdh.ardhitilts.hack;

import com.simibubi.create.content.contraptions.sync.ClientMotionPacket;
import dev.rdh.ardhitilts.config.ArdhitiltsConfig;
import dev.rdh.ardhitilts.util.Utils;
import net.minecraft.client.Minecraft;

public class NoFall {
	private static final Minecraft MC = Minecraft.getInstance();

	public static void breakFall() {
		if(!ArdhitiltsConfig.INSTANCE.noFall.get()) return;
		if(MC.player == null) return;
		Utils.sendPacket(new ClientMotionPacket(MC.player.getDeltaMovement(), true, 0.0F));
	}
}
