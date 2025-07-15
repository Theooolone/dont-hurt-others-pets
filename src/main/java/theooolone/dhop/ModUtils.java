package theooolone.dhop;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.TameableEntity;
import theooolone.dhop.mixin.FoxEntityInvoker;

public class ModUtils {
	public static boolean isEntityTamedByOtherPlayer(Entity target, Entity player) {
		// Foxes are handled uniquely
		if ((target instanceof FoxEntity)) {
			if (((FoxEntityInvoker) target).invokeGetTrustedEntities().findAny().isEmpty()) return false;
			return !((FoxEntityInvoker) target).invokeCanTrust((LivingEntity) player);
		}
		if (!(target instanceof TameableEntity)) return false;
		if (((TameableEntity) target).getOwnerReference() == null) return false;
		return !((TameableEntity) target).getOwnerReference().uuidEquals((LivingEntity) player);
	}
}
