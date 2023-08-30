package dev.rdh.ardhitilts.registry;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class Keybinds {
	public static final KeyMapping toggleFly = new KeyMapping("key.ardhitilts.fly", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_EQUAL, "key.categories.misc");
	public static final KeyMapping toggleNoFall = new KeyMapping("key.ardhitilts.nofall", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_MINUS, "key.categories.misc");
}
