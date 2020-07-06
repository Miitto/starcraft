package net.mod.starcraft.procedures;

import net.mod.starcraft.ScModElements;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

@ScModElements.ModElement.Tag
public class AcidMobplayerCollidesBlockProcedure extends ScModElements.ModElement {
	public AcidMobplayerCollidesBlockProcedure(ScModElements instance) {
		super(instance, 70);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AcidMobplayerCollidesBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 1);
	}
}
