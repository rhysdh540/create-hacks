package dev.rdh.ardhitilts.hack;

import com.simibubi.create.content.contraptions.sync.ClientMotionPacket;
import dev.rdh.ardhitilts.config.ArdhitiltsConfig;
import dev.rdh.ardhitilts.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class FlyHack {
	private static final Minecraft MC = Minecraft.getInstance();
	private static double scale = 5;

	public static void performFly() {
		if(!ArdhitiltsConfig.INSTANCE.fly.get()) return;
		if(MC.player == null) return;
		scale = ArdhitiltsConfig.INSTANCE.flySpeed.get();

		Vec3 movement = getVerticalVec();
		if(MC.player.getAbilities().mayfly || movement.y > -0.1) {
			movement = movement.add(getHorizontalVec());
		}

		Utils.sendPacket(new ClientMotionPacket(movement, true, 0.0F));
		MC.player.setDeltaMovement(movement);
	}

	private static Vec3 getVerticalVec() {
		Vec3 movement = Vec3.ZERO;
		if(MC.options.keyJump.isDown()) {
			movement = movement.add(0.0, 0.1 * scale, 0.0);
		}

		if(MC.options.keyShift.isDown()) {
			movement = movement.add(0.0, -0.1 * scale, 0.0);
		}

		return movement;
	}

	private static Vec3 getHorizontalVec() {
		Vec2 vector2f = MC.player.input.getMoveVector();
		float moveSpeed = MC.player.getSpeed();
		float xVel = moveSpeed * vector2f.x;
		float zVel = moveSpeed * vector2f.y;
		double xYaw = Math.cos(Math.toRadians(MC.player.yRotO));
		double zYaw = Math.sin(Math.toRadians(MC.player.yRotO));

		double x = xVel * xYaw - zVel * zYaw;
		double z = zVel * xYaw + xVel * zYaw;

		if(MC.player.getAbilities().mayfly && MC.player.isCrouching()) {
			x *= 3.125;
			z *= 3.125;
		}

		return new Vec3(x, 0.0, z).scale(scale);
	}
}
