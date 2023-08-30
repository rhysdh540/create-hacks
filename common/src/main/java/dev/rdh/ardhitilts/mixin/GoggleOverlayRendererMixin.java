package dev.rdh.ardhitilts.mixin;

import com.simibubi.create.content.equipment.goggles.GoggleOverlayRenderer;
import com.simibubi.create.content.equipment.goggles.GogglesItem;
import dev.rdh.ardhitilts.config.ArdhitiltsConfig;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GoggleOverlayRenderer.class)
public class GoggleOverlayRendererMixin {
	@Redirect(method = "renderOverlay", at = @At(value = "INVOKE", target = "Lcom/simibubi/create/content/equipment/goggles/GogglesItem;isWearingGoggles(Lnet/minecraft/world/entity/player/Player;)Z"))
	private static boolean definitelyWearingGoggles(Player player) {
		return ArdhitiltsConfig.client().goggles.get() || GogglesItem.isWearingGoggles(player);
	}
}
