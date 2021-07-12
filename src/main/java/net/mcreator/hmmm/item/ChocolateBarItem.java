
package net.mcreator.hmmm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.hmmm.procedures.ChocolateBarEatenProcedure;
import net.mcreator.hmmm.HmmmModElements;

import java.util.Map;
import java.util.HashMap;

@HmmmModElements.ModElement.Tag
public class ChocolateBarItem extends HmmmModElements.ModElement {
	@ObjectHolder("hmmm:chocolate_bar")
	public static final Item block = null;
	public ChocolateBarItem(HmmmModElements instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(4).saturation(1f).setAlwaysEdible().build()));
			setRegistryName("chocolate_bar");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 20;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ChocolateBarEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
