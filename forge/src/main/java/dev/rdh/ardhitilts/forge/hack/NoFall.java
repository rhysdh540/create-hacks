package dev.rdh.ardhitilts.forge.hack;

import com.simibubi.create.AllPackets;
import com.simibubi.create.content.contraptions.sync.ClientMotionPacket;
import dev.rdh.ardhitilts.Ardhitilts;
import dev.rdh.ardhitilts.config.ArdhitiltsConfig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Ardhitilts.ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class NoFall {
	private static final Minecraft MC = Minecraft.getInstance();

	@SubscribeEvent
	public static void breakFall(ClientTickEvent event) {
		if(!ArdhitiltsConfig.INSTANCE.noFall.get()) return;
		if(MC.player == null) return;
		AllPackets.getChannel().sendToServer(new ClientMotionPacket(MC.player.getDeltaMovement(), true, 0.0F));
	}

}
