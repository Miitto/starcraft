
package net.mod.starcraft.item;

import net.mod.starcraft.procedures.StardustLivingEntityIsHitWithItemProcedure;
import net.mod.starcraft.procedures.StardustItemIsCraftedsmeltedProcedure;
import net.mod.starcraft.itemgroup.StarcraftToolsItemGroup;
import net.mod.starcraft.ScModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;

@ScModElements.ModElement.Tag
public class ChargedAxeItem extends ScModElements.ModElement {
	@ObjectHolder("sc:charged_axe")
	public static final Item block = null;
	public ChargedAxeItem(ScModElements instance) {
		super(instance, 15);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 7500;
			}

			public float getEfficiency() {
				return 50f;
			}

			public float getAttackDamage() {
				return 58f;
			}

			public int getHarvestLevel() {
				return 20;
			}

			public int getEnchantability() {
				return 140;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ChargedAsteroidIngotItem.block, (int) (1)), new ItemStack(Items.DIAMOND, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(StarcraftToolsItemGroup.tab)) {
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

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("charged_axe"));
	}
}
