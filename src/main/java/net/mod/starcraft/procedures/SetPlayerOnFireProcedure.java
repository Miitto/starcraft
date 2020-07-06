package net.mod.starcraft.procedures;

import net.mod.starcraft.ScModElements;

import net.minecraft.entity.Entity;

@ScModElements.ModElement.Tag
public class SetPlayerOnFireProcedure extends ScModElements.ModElement {
	public SetPlayerOnFireProcedure(ScModElements instance) {
		super(instance, 61);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SetPlayerOnFire!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 1);
	}
}
