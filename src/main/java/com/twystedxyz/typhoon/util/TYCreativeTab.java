package com.twystedxyz.typhoon.util;

import com.twystedxyz.typhoon.Typhoon;
import com.twystedxyz.typhoon.content.TYItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class TYCreativeTab {
    private static final CreativeModeTab.Builder ITEM_GROUP_BUILDER = FabricItemGroup.builder().title(Component.translatable("itemGroup.typhoon")).icon(() -> new ItemStack(TYItems.BREEZE_RING)).displayItems(((displayContext, entries) -> {

        entries.accept(TYItems.BREEZE_SHOVEL);
        entries.accept(TYItems.BREEZE_PICKAXE);
        entries.accept(TYItems.BREEZE_AXE);
        entries.accept(TYItems.BREEZE_HOE);
        entries.accept(TYItems.BREEZE_SWORD);
        entries.accept(TYItems.BREEZE_HELMET);
        entries.accept(TYItems.BREEZE_CHESTPLATE);
        entries.accept(TYItems.BREEZE_LEGGINGS);
        entries.accept(TYItems.BREEZE_BOOTS);

        entries.accept(TYItems.BREEZE_RING);

        entries.accept(TYItems.BREEZE_UPGRADE_SMITHING_TEMPLATE);
    }));

    public static CreativeModeTab INFERNO;

    public static void init() {
        INFERNO = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Typhoon.rl("typhoon"), ITEM_GROUP_BUILDER.build());
        Typhoon.LOGGER.debug("Registering creative tab");
    }
}
