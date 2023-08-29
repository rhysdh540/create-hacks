package net.examplegroup.examplemod;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;

import static net.examplegroup.examplemod.ExampleMod.REGISTRATE;

public class ExampleBlocks {

	public static final BlockEntry<Block> EXAMPLE_BLOCK = REGISTRATE.block("example_block", Block::new).register();

	public static void init() {
		// load the class and register everything
		ExampleMod.LOGGER.info("Registering blocks for " + ExampleMod.NAME);
	}
}
