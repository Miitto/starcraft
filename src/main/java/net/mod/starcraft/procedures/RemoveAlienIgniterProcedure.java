package net.mod.starcraft.procedures;

import net.mod.starcraft.item.AlienWorldItem;
import net.mod.starcraft.ScModElements;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

@ScModElements.ModElement.Tag
public class RemoveAlienIgniterProcedure extends ScModElements.ModElement {
	public RemoveAlienIgniterProcedure(ScModElements instance) {
		super(instance, 68);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RemoveAlienIgniter!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(AlienWorldItem.block, (int) (1)).getItem() == p.getItem(),
					(int) 1);
	}
}
