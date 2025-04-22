package com.twystedxyz.typhoon.content;

import com.twystedxyz.typhoon.Typhoon;
import com.twystedxyz.typhoon.content.items.*;
import com.twystedxyz.typhoon.util.TYArmorMaterials;
import com.twystedxyz.typhoon.util.TYTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

import java.util.List;

@SuppressWarnings("unused")
public class TYItems {
    public static final Item BREEZE_UPGRADE_SMITHING_TEMPLATE = register("breeze_upgrade_smithing_template", createBreezeUpgradeSmithingTemplate());
    public static final Item BREEZE_RING = register("breeze_ring", new Item(new Item.Properties().rarity(Rarity.RARE).fireResistant()));
    public static final Item BREEZE_HELMET = register("breeze_helmet", new BreezeArmorItem(TYArmorMaterials.BREEZE, ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.RARE).fireResistant().durability(ArmorItem.Type.HELMET.getDurability(40))));
    public static final Item BREEZE_CHESTPLATE = register("breeze_chestplate", new BreezeArmorItem(TYArmorMaterials.BREEZE, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.RARE).fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))));
    public static final Item BREEZE_LEGGINGS = register("breeze_leggings", new BreezeArmorItem(TYArmorMaterials.BREEZE, ArmorItem.Type.LEGGINGS, new Item.Properties().rarity(Rarity.RARE).fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(40))));
    public static final Item BREEZE_BOOTS = register("breeze_boots", new BreezeArmorItem(TYArmorMaterials.BREEZE, ArmorItem.Type.BOOTS, new Item.Properties().rarity(Rarity.RARE).fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(40))));
    public static final Item BREEZE_SHOVEL = register("breeze_shovel", new ShovelItem(TYTiers.BREEZE, new Item.Properties().attributes(ShovelItem.createAttributes(TYTiers.BREEZE, 1.5f, -3)).rarity(Rarity.RARE).fireResistant()));
    public static final Item BREEZE_PICKAXE = register("breeze_pickaxe", new PickaxeItem(TYTiers.BREEZE, new Item.Properties().attributes(PickaxeItem.createAttributes(TYTiers.BREEZE, 1, -2.8f)).rarity(Rarity.RARE).fireResistant()));
    public static final Item BREEZE_AXE = register("breeze_axe", new AxeItem(TYTiers.BREEZE, new Item.Properties().attributes(AxeItem.createAttributes(TYTiers.BREEZE, 5, -3)).rarity(Rarity.RARE).fireResistant()));
    public static final Item BREEZE_HOE = register("breeze_hoe", new HoeItem(TYTiers.BREEZE, new Item.Properties().attributes(HoeItem.createAttributes(TYTiers.BREEZE, -4, 0)).rarity(Rarity.RARE).fireResistant()));
    public static final Item BREEZE_SWORD = register("breeze_sword", new SwordItem(TYTiers.BREEZE, new Item.Properties().attributes(SwordItem.createAttributes(TYTiers.BREEZE, 3, -2.4f)).rarity(Rarity.RARE).fireResistant()));

    public static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, Typhoon.rl(id), item);
    }

    private static Item createBreezeUpgradeSmithingTemplate() {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", Typhoon.rl("smithing_template.breeze_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", Typhoon.rl("smithing_template.breeze_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("upgrade", Typhoon.rl("breeze_upgrade"))).withStyle(ChatFormatting.GRAY),
                Component.translatable(Util.makeDescriptionId("item", Typhoon.rl("smithing_template.breeze_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", Typhoon.rl("smithing_template.breeze_upgrade.additions_slot_description"))),
                getBreezeEmptyBaseSlotTextures(),
                getBreezeEmptyAdditionsSlotTextures());
    }

    private static List<ResourceLocation> getBreezeEmptyBaseSlotTextures() {
        return List.of(ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet"),
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate"),
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings"),
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_sword"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_axe"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_shovel"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_hoe"));
    }

    private static List<ResourceLocation> getBreezeEmptyAdditionsSlotTextures() {
        return List.of(Typhoon.rl("item/empty_slot_breeze_ring"));
    }

    public static void init() {
        Typhoon.LOGGER.debug("Registering items");
    }
}
