package net.examplegroup.examplemod.multiloader;

import dev.architectury.injectables.annotations.ExpectPlatform;
import org.jetbrains.annotations.ApiStatus.Internal;

import java.util.function.Supplier;

public enum Loader {
	FABRIC,
	FORGE,
	QUILT;

	public static final Loader CURRENT = getCurrent();

	public boolean isCurrent() {
		return (CURRENT == QUILT && this == FABRIC) || CURRENT == this;
	}

	public void runIfCurrent(Supplier<Runnable> run) {
		if (isCurrent())
			run.get().run();
	}

	@Override
	public String toString() {
		String n = name();
		return n.charAt(0) + n.substring(1).toLowerCase();
	}

	@Internal
	@ExpectPlatform
	public static Loader getCurrent() {
		throw new AssertionError();
	}
}
