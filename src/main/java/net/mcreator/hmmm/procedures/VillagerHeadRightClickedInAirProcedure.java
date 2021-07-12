package net.mcreator.hmmm.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.hmmm.item.VillagerHeadItem;
import net.mcreator.hmmm.HmmmMod;

import java.util.Map;

public class VillagerHeadRightClickedInAirProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				HmmmMod.LOGGER.warn("Failed to load dependency entity for procedure VillagerHeadRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = ((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
					: ItemStack.EMPTY);
			_setstack.setCount((int) 1);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		if (entity instanceof LivingEntity) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(VillagerHeadItem.block, (int) (1)));
			else
				((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
						new ItemStack(VillagerHeadItem.block, (int) (1)));
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
		if (entity instanceof LivingEntity) {
			ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
			_setstack.setCount((int) 1);
			((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
			if (entity instanceof ServerPlayerEntity)
				((ServerPlayerEntity) entity).inventory.markDirty();
		}
	}
}
