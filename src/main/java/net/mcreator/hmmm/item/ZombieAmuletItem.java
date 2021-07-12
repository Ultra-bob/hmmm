
package net.mcreator.hmmm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import net.mcreator.hmmm.procedures.ZombieAmuletRightClickedInAirProcedure;
import net.mcreator.hmmm.HmmmModElements;

import java.util.Map;
import java.util.HashMap;

@HmmmModElements.ModElement.Tag
public class ZombieAmuletItem extends HmmmModElements.ModElement {
	@ObjectHolder("hmmm:zombie_amulet")
	public static final Item block = null;
	public ZombieAmuletItem(HmmmModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.TOOLS).maxStackSize(1).isImmuneToFire().rarity(Rarity.RARE));
			setRegistryName("zombie_amulet");
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
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				ZombieAmuletRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
			return ar;
		}
	}
}
