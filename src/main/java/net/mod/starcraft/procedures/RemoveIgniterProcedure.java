package net.mod.starcraft.procedures;

import net.mod.starcraft.item.AsteroidWorldItem;
import net.mod.starcraft.ScModElements;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

@ScModElements.ModElement.Tag
public class RemoveIgniterProcedure extends ScModElements.ModElement {
	public RemoveIgniterProcedure(ScModElements instance) {
		super(instance, 58);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RemoveIgniter!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(AsteroidWorldItem.block, (int) (1)).getItem() == p.getItem(),
					(int) 1);
	}
}
