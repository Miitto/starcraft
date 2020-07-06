
package net.mod.starcraft.itemgroup;

import net.mod.starcraft.block.AsteroidMinteralClusterBlock;
import net.mod.starcraft.ScModElements;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

@ScModElements.ModElement.Tag
public class StarcraftBlocksItemGroup extends ScModElements.ModElement {
	public StarcraftBlocksItemGroup(ScModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabstarcraft_blocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(AsteroidMinteralClusterBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
