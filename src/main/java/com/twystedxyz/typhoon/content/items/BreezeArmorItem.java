package com.twystedxyz.typhoon.content.items;

import com.twystedxyz.typhoon.Typhoon;
import com.twystedxyz.typhoon.util.TYArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.List;

public class BreezeArmorItem extends ArmorItem {
    private final List<Holder<MobEffect>> immunities;

    public BreezeArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        this(material, type, properties, List.of());
    }

    public BreezeArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties, List<Holder<MobEffect>> immunities) {
        super(material, type, properties);
        this.immunities = immunities;
    }

    public static ItemAttributeModifiers createAttributes() {
        ResourceLocation location = Typhoon.rl("armor.breeze");
        return ItemAttributeModifiers.builder()
                .add(Attributes.ARMOR, new AttributeModifier(location, TYArmorMaterials.BREEZE.value().getDefense(Type.LEGGINGS), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS)
                .add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(location, TYArmorMaterials.BREEZE.value().toughness(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS)
                .add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(location, TYArmorMaterials.BREEZE.value().knockbackResistance(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS)
                .add(Attributes.MOVEMENT_SPEED, new AttributeModifier(location, 0.05, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.LEGS).build();
    }
}
