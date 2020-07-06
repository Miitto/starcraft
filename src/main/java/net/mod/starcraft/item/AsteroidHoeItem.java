
package net.mod.starcraft.item;

import net.mod.starcraft.itemgroup.StarcraftToolsItemGroup;
import net.mod.starcraft.ScModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

@ScModElements.ModElement.Tag
public class AsteroidHoeItem extends ScModElements.ModElement {
	@ObjectHolder("sc:asteroid_hoe")
	public static final Item block = null;
	public AsteroidHoeItem(ScModElements instance) {
		super(instance, 13);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1741;
			}

			public float getEfficiency() {
				return 17f;
			}

			public float getAttackDamage() {
				return 6f;
			}

			public int getHarvestLevel() {
				return 8;
			}

			public int getEnchantability() {
				return 56;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, -3f, new Item.Properties().group(StarcraftToolsItemGroup.tab)) {
		}.setRegistryName("asteroid_hoe"));
	}
}
