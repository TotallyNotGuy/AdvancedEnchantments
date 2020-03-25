package me.egg82.ae.tasks;

import java.util.Optional;
import me.egg82.ae.APIException;
import me.egg82.ae.EnchantAPI;
import me.egg82.ae.api.AdvancedEnchantment;
import me.egg82.ae.api.BukkitEnchantableItem;
import me.egg82.ae.api.GenericEnchantableItem;
import me.egg82.ae.utils.PermissionUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskAcceleration implements Runnable {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private EnchantAPI api = EnchantAPI.getInstance();

    public TaskAcceleration() { }

    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {

            if (!PermissionUtil.canUseEnchant(player, "ae.enchant.antigravity")) {
                continue;
            }

            Optional<EntityEquipment> equipment = Optional.ofNullable(player.getEquipment());
            if (!equipment.isPresent()) {
                continue;
            }

            GenericEnchantableItem enchantableBoots = BukkitEnchantableItem.fromItemStack(equipment.get().getBoots());

            boolean hasEnchantment;
            int level;
            try {
                hasEnchantment = api.anyHasEnchantment(AdvancedEnchantment.ACCELERATION, enchantableBoots);
                level = api.getMaxLevel(AdvancedEnchantment.ACCELERATION, enchantableBoots);
            } catch (APIException ex) {
                logger.error(ex.getMessage(), ex);
                continue;
            }

            if (!hasEnchantment || level <= 0) {
                continue;
            }

            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 31, level - 1, true, false), true);
        }
    }
}
