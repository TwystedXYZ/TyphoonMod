package com.twystedxyz.typhoon.util;

import com.twystedxyz.typhoon.Typhoon;
import com.twystedxyz.typhoon.content.TYItems;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@SuppressWarnings("NullableProblems")
public class TYArmorMaterials {
        public static Holder<ArmorMaterial> BREEZE = register("breeze", Map.of(
        ArmorItem.Type.BOOTS, 4,
        ArmorItem.Type.LEGGINGS, 7,
        ArmorItem.Type.CHESTPLATE, 9,
        ArmorItem.Type.HELMET, 4
    ), 18, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(TYItems.BREEZE_RING), 4.0f, 0.1f);

    private static Holder<ArmorMaterial> register(String id, Map<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, Supplier<Ingredient> repairIngredient, float toughness, float knockbackResistance) {
        ArmorMaterial armorMaterial = new ArmorMaterial(defense, enchantmentValue, equipSound, repairIngredient, List.of(new ArmorMaterial.Layer(Typhoon.rl(id))), toughness, knockbackResistance);
        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, Typhoon.rl(id), armorMaterial);
    }

    public static void init() {
        Typhoon.LOGGER.debug("Registering armor materials");
    }
}
