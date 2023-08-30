package dev.rdh.ardhitilts.mixin;

import com.simibubi.create.content.trains.entity.TrainRelocator;
import dev.rdh.ardhitilts.config.ArdhitiltsConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(TrainRelocator.class)
public class TrainRelocatorMixin {
	@ModifyConstant(method = {"onClicked", "clientTick"}, constant = @Constant(doubleValue = 24), remap = false)
	private static double a(double og) {
		return ArdhitiltsConfig.INSTANCE.trainMoveDistance.get();
	}
}
