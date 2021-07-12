package net.mcreator.hmmm.procedures;

public class EntityHitWithPickpocketProcedure {

	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityDeath(LivingDeathEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				HmmmMod.LOGGER.warn("Failed to load dependency sourceentity for procedure EntityHitWithPickpocket!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				HmmmMod.LOGGER.warn("Failed to load dependency x for procedure EntityHitWithPickpocket!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				HmmmMod.LOGGER.warn("Failed to load dependency y for procedure EntityHitWithPickpocket!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				HmmmMod.LOGGER.warn("Failed to load dependency z for procedure EntityHitWithPickpocket!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				HmmmMod.LOGGER.warn("Failed to load dependency world for procedure EntityHitWithPickpocket!");
			return;
		}

		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");

		if ((Math.random() < 0.3)) {
			for (int index0 = 0; index0 < (int) (Math.ceil((Math.random() * (EnchantmentHelper.getEnchantmentLevel(PickpocketEnchantment.enchantment,
					((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)))))); index0++) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.EMERALD, (int) (1)));
					entityToSpawn.setPickupDelay((int) 3);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}

}
