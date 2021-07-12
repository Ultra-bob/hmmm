
package net.mcreator.hmmm.enchantment;

@HmmmModElements.ModElement.Tag
public class PickpocketEnchantment extends HmmmModElements.ModElement {

	@ObjectHolder("hmmm:pickpocket")
	public static final Enchantment enchantment = null;

	public PickpocketEnchantment(HmmmModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("pickpocket"));
	}

	public static class CustomEnchantment extends Enchantment {

		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.COMMON, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 5;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}

	}

}
