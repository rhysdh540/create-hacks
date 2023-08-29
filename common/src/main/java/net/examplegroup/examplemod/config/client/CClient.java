package net.examplegroup.examplemod.config.client;

import com.simibubi.create.foundation.config.ConfigBase;

public class CClient extends ConfigBase {
	@Override
	public String getName() {
		return "client";
	}

	public final ConfigBool exampleBool = b(false, "exampleBool", Comments.exampleBool);

	public static class Comments {
		public static final String exampleBool = "An example boolean.";
	}
}
