package theooolone.dhop.mixin;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import theooolone.dhop.ModUtils;

@Mixin(Entity.class)
public class EntityMixin {
	@Inject(method = "handleAttack", at = @At("HEAD"), cancellable = true)
	public void handleAttackInject(Entity attacker, CallbackInfoReturnable<Boolean> cir) {
		if (ModUtils.isEntityTamedByOtherPlayer((Entity) (Object) this, attacker)) cir.setReturnValue(true);
	}
}
