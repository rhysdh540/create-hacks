package dev.rdh.ardhitilts.mixin;

import com.simibubi.create.content.equipment.goggles.GogglesItem;
import dev.rdh.ardhitilts.config.ArdhitiltsConfig;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.function.Predicate;

@Mixin(GogglesItem.class)
public class GogglesItemMixin {
	@Final
	@Shadow
	private static List<Predicate<Player>> IS_WEARING_PREDICATES;
	/**
	 * @author rdh
	 * @reason unfortunately this is the best way to do this since loader differences would otherwise make it a mess
	 */
	@Overwrite(remap = false)
	public static boolean isWearingGoggles(Player player) {
		if(ArdhitiltsConfig.INSTANCE.goggles.get()) return true;
		for (Predicate<Player> predicate : IS_WEARING_PREDICATES) {
			if (predicate.test(player)) {
				return true;
			}
		}
		return false;
	}
}
