package dev.rdh.ardhitilts.mixin;

import com.simibubi.create.content.equipment.extendoGrip.ExtendoGripItem;
import dev.rdh.ardhitilts.config.ArdhitiltsConfig;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.UUID;

@Mixin(ExtendoGripItem.class)
public class ExtendoGripItemMixin {

	@Final
	@Shadow
	@Mutable
	public static final AttributeModifier singleRangeAttributeModifier = new AttributeModifier(UUID.fromString("7f7dbdb2-0d0d-458a-aa40-ac7633691f66"), "Range modifier", 100,
			AttributeModifier.Operation.ADDITION);

	@Redirect(method = "dontMissEntitiesWhenYouHaveHighReachDistance", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/ai/attributes/AttributeInstance;getValue()D"))
	private static double a(AttributeInstance instance) {
		double value = instance.getValue();
		double hackValue = ArdhitiltsConfig.client().reach.get();

		return value + hackValue;
	}
}
