package me.egg82.ae.api.enchantments;

import java.util.Arrays;
import java.util.UUID;
import me.egg82.ae.api.AdvancedEnchantment;
import me.egg82.ae.api.AdvancedEnchantmentTarget;
import me.egg82.ae.api.GenericEnchantment;


public class AccelerationEnchantment extends AdvancedEnchantment {
    public AccelerationEnchantment() {
        super(UUID.randomUUID(), "acceleration", "Acceleration", false, 1, 3);
        targets.add(AdvancedEnchantmentTarget.ARMOR_FEET);
        conflicts.addAll(Arrays.asList(AdvancedEnchantment.ANTIGRAVITY,AdvancedEnchantment.AEGIS));
    }
}
