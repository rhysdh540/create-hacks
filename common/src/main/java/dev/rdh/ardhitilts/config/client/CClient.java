package dev.rdh.ardhitilts.config.client;

import com.simibubi.create.foundation.config.ConfigBase;

public class CClient extends ConfigBase {
	@Override
	public String getName() {
		return "client";
	}

	public final ConfigFloat reach = f(0, 0, "reach", Comments.reach);
	public final ConfigBool fly = b(false, "fly", Comments.fly);
	public final ConfigBool goggles = b(false, "goggles", Comments.goggles);

	private static class Comments {
		public static final String reach = "Reach distance. Adds to your base reach.";
		public static final String fly = "Fly.";
		public static final String goggles = "Show goggle tooltips without wearing goggles.";
	}
}
