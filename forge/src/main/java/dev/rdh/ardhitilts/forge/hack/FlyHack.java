package dev.rdh.ardhitilts.forge.hack;

import com.simibubi.create.content.contraptions.sync.ClientMotionPacket;
import com.simibubi.create.AllPackets;
import dev.rdh.ardhitilts.Ardhitilts;
import dev.rdh.ardhitilts.config.ArdhitiltsConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = Ardhitilts.ID, bus = Bus.FORGE, value = Dist.CLIENT)
public class FlyHack {
	private static final Minecraft MC = Minecraft.getInstance();
	private static double scale = 1;

	@SubscribeEvent
	public static void performFly(ClientTickEvent event) {
		if(!ArdhitiltsConfig.INSTANCE.fly.get()) return;
		if(MC.player == null) return;
		scale = ArdhitiltsConfig.INSTANCE.flySpeed.get();
		//Ardhitilts.LOGGER.info("scale: " + scale);

		Vec3 movement = getJumpVec();
		AllPackets.getChannel().sendToServer(new ClientMotionPacket(movement, true, 0.0F));
		MC.player.setDeltaMovement(movement);
	}

	private static Vec3 getJumpVec() {
		Vec3 movement = Vec3.ZERO;
		if(MC.options.keyJump.isDown())
			movement = movement.add(0.0, 0.1 * scale, 0.0);

		if(MC.options.keyShift.isDown() && movement.x == 0.0 && movement.z == 0.0)
			movement = movement.add(0.0, -0.1 * scale, 0.0);

		return movement.y < -0.1 ? movement : movement.add(asVec3d());
	}

	private static Vec3 asVec3d() {
		if(MC.player == null) return Vec3.ZERO;

		Vec2 vector2f = MC.player.input.getMoveVector();
		float f = MC.player.getSpeed();
		float f2 = f * vector2f.x;
		float f3 = f * vector2f.y;
		double f4 = Math.sin(MC.player.yRotO * (float) (Math.PI / 180.0));
		double f5 = Math.cos(MC.player.yRotO * (float) (Math.PI / 180.0));
		return new Vec3((double)f2 * f5 - (double)f3 * f4, 0.0, (double)f3 * f5 + (double)f2 * f4).scale(scale);
	}
}
