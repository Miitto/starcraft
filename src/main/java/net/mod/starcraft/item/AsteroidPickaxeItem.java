
package net.mod.starcraft.item;

import net.mod.starcraft.procedures.StardustLivingEntityIsHitWithItemProcedure;
import net.mod.starcraft.procedures.StardustItemIsCraftedsmeltedProcedure;
import net.mod.starcraft.itemgroup.StarcraftToolsItemGroup;
import net.mod.starcraft.ScModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;

@ScModElements.ModElement.Tag
public class AsteroidPickaxeItem extends ScModElements.ModElement {
	@ObjectHolder("sc:asteroid_pickaxe")
	public static final Item block = null;
	public AsteroidPickaxeItem(ScModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
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
				return Ingredient.fromStacks(new ItemStack(AsteroidIngotItem.block, (int) (1)));
			}
		}, 1, -2f, new Item.Properties().group(StarcraftToolsItemGroup.tab)) {
			@Override
			public void onCreated(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onCreated(itemstack, world, entity);
				int x = (int) entity.getPosX();
				int y = (int) entity.getPosY();
				int z = (int) entity.getPosZ();
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					StardustItemIsCraftedsmeltedProcedure.executeProcedure($_dependencies);
				}
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				int x = (int) entity.getPosX();
				int y = (int) entity.getPosY();
				int z = (int) entity.getPosZ();
				World world = entity.world;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					StardustLivingEntityIsHitWithItemProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("asteroid_pickaxe"));
	}
}
