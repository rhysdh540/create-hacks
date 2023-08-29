package net.examplegroup.examplemod.multiloader.fabric;

import net.examplegroup.examplemod.multiloader.Loader;
import net.fabricmc.loader.api.FabricLoader;

public class LoaderImpl {
	@org.jetbrains.annotations.ApiStatus.Internal
	public static Loader getCurrent() {
		return FabricLoader.getInstance().isModLoaded("quilt_loader") ? Loader.QUILT : Loader.FABRIC;
	}
}
