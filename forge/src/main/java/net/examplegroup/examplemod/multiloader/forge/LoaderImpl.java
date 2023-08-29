package net.examplegroup.examplemod.multiloader.forge;

import net.examplegroup.examplemod.multiloader.Loader;
import org.jetbrains.annotations.ApiStatus;

public class LoaderImpl {
	@ApiStatus.Internal
	public static Loader getCurrent() {
		return Loader.FORGE;
	}
}
