
package net.mod.starcraft.item;

import net.mod.starcraft.procedures.StardustLivingEntityIsHitWithItemProcedure;
import net.mod.starcraft.procedures.StardustItemIsCraftedsmeltedProcedure;
import net.mod.starcraft.itemgroup.StarcraftMaterialsItemGroup;
import net.mod.starcraft.ScModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

@ScModElements.ModElement.Tag
public class ChargedStickItem extends ScModElements.ModElement {
	@ObjectHolder("sc:charged_stick")
	public static final Item block = null;
	public ChargedStickItem(ScModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(StarcraftMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("charged_stick");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
			super.hitEntity(itemstack, entity, sourceentity);
			int x = (int) entity.getPosX();
			int y = (int) entity.getPosY();
			int z = (int) entity.getPosZ();
			World world = entity.world;
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				StardustLivingEntityIsHitWithItemProcedure.executeProcedure($_dependencies);
			}
			return true;
		}

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
	}
}
