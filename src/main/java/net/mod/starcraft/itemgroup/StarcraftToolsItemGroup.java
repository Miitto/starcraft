
package net.mod.starcraft.itemgroup;

import net.mod.starcraft.item.ChargedPickaxeItem;
import net.mod.starcraft.ScModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@ScModElements.ModElement.Tag
public class StarcraftToolsItemGroup extends ScModElements.ModElement {
	public StarcraftToolsItemGroup(ScModElements instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabstarcraft_tools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ChargedPickaxeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
