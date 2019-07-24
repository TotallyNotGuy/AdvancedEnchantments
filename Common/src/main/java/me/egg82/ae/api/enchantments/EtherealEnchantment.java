package me.egg82.ae.api.enchantments;

import java.util.UUID;
import me.egg82.ae.api.AdvancedEnchantment;
import me.egg82.ae.api.AdvancedEnchantmentTarget;

public class EtherealEnchantment extends AdvancedEnchantment {
    public EtherealEnchantment() {
        super(UUID.randomUUID(), "ethereal", "Ethereal", false, 1, 1);
        targets.add(AdvancedEnchantmentTarget.ARMOR);
    }
}
