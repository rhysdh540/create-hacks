package net.examplegroup.examplemod.config.common;

import com.simibubi.create.foundation.config.ConfigBase;

public class CCommon extends ConfigBase {
	@Override
	public String getName() {
		return "common";
	}

	public final ConfigInt exampleInt = i(1, 0, 10, "exampleInt", Comments.exampleInt);

	private static class Comments {
		static String exampleInt = "An example integer.";
	}
}
