package net.examplegroup.examplemod.config.server;

import com.simibubi.create.foundation.config.ConfigBase;

public class CServer extends ConfigBase {
	@Override
	public String getName() {
		return "server";
	}

	public final ConfigEnum<ExampleEnum> exampleEnum = e(ExampleEnum.A, "exampleEnum", Comments.exampleEnum);

	private static class Comments {
		static String exampleEnum = "An example enum.";
	}

	public enum ExampleEnum {
		A,
		B,
		C
	}
}
