package com.twystedxyz.typhoon;

import com.twystedxyz.typhoon.util.TYCreativeTab;
import com.twystedxyz.typhoon.content.TYItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Typhoon implements ModInitializer {
	public static final String MOD_ID = "typhoon";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final boolean SHOW_ME_YOUR_SKIN = FabricLoader.getInstance().isModLoaded("showmeyourskin");

	@Override
	public void onInitialize() {
		TYCreativeTab.init();
		TYItems.init();


		LootTableEvents.MODIFY.register((key, tableBuilder, source) -> {
			if (source == LootTableSource.DATA_PACK) return;

			if (BuiltInLootTables.TRIAL_CHAMBERS_REWARD_OMINOUS_UNIQUE == key) {
				LootPool.Builder breezeUpgradePoolBuilder = LootPool.lootPool()
						.add(LootItem.lootTableItem(TYItems.BREEZE_UPGRADE_SMITHING_TEMPLATE))
						.when(LootItemRandomChanceCondition.randomChance(0.2f));

				tableBuilder.withPool(breezeUpgradePoolBuilder);
			}

		});
	}

	public static ResourceLocation rl(String path) {
		return ResourceLocation.fromNamespaceAndPath(Typhoon.MOD_ID, path);
	}
}
