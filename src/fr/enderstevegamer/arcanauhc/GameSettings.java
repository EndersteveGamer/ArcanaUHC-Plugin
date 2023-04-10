package fr.enderstevegamer.arcanauhc;

import org.bukkit.ChatColor;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;

public class GameSettings {
    public static final String DIAMOND_HELMET = "diamond_helmet";
    public static final String DIAMOND_CHESTPLATE = "diamond_chestplate";
    public static final String DIAMOND_LEGGINGS = "diamond_leggings";
    public static final String DIAMOND_BOOTS = "diamond_boots";
    public static final String DIAMOND_SWORDS = "diamond_swords";
    public static final String ENCHANTMENT_TABLES = "enchantment_tables";
    public static final String LAVA_BUCKETS = "lava_buckets";
    public static final String ENDER_PEARLS = "ender_pearls";
    public static final String BREWING_STANDS = "brewing_stands";
    public static final String BOWS = "bows";
    public static final String BOOKSHELVES = "bookshelves";
    public static final String FLINT_AND_STEEL = "flint_and_steel";
    public static final String FISHING_ROD = "fishing_rod";
    public static final String LEVEL_2_POTIONS = "level_2_potions";
    public static final String DIAMOND_ARMORS_LIMIT = "diamond_armors_limit";
    public static final String DIAMOND_LIMIT = "diamond_limit";
    public static final String GOLDEN_APPLE_ON_KILL = "golden_apple_on_kill";

    public static class EnchantsLimits {
        public static final String SHARPNESS = "sharpness";
        public static final String FIRE_ASPECT = "fire_aspect";
        public static final String KNOCKBACK = "knockback";
        public static final String THORNS = "thorns";
        public static final String FEATHER_FALLING = "feather_falling";
        public static final String DEPTH_STRIDER = "depth_strider";
        public static final String INFINITY = "infinity";
        public static final String FLAME = "flame";
        public static final String PUNCH = "punch";
    }

    public static HashMap<String, Boolean> booleanSettings = new HashMap<>();
    public static HashMap<String, Integer> integerSettings = new HashMap<>();

    public static void setBooleanSetting(String setting, boolean value) {
        booleanSettings.put(setting, value);
    }

    public static boolean getBooleanSetting(String setting) {
        return booleanSettings.get(setting);
    }

    public static void setIntegerSettings(String setting, int value) {
        integerSettings.put(setting, value);
    }

    public static int getIntegerSetting(String setting) {
        return integerSettings.get(setting);
    }

    public static void addIntegerSetting(String setting, int value) {
        setIntegerSettings(setting, getIntegerSetting(setting) + value);
    }

    public static void resetSettings() {
        setBooleanSetting(DIAMOND_HELMET, true);
        setBooleanSetting(DIAMOND_CHESTPLATE, true);
        setBooleanSetting(DIAMOND_LEGGINGS, true);
        setBooleanSetting(DIAMOND_BOOTS, true);
        setBooleanSetting(DIAMOND_SWORDS, true);
        setBooleanSetting(ENCHANTMENT_TABLES, true);
        setBooleanSetting(LAVA_BUCKETS, true);
        setBooleanSetting(ENDER_PEARLS, true);
        setBooleanSetting(BREWING_STANDS, true);
        setBooleanSetting(BOWS, true);
        setBooleanSetting(BOOKSHELVES, true);
        setBooleanSetting(FLINT_AND_STEEL, true);
        setBooleanSetting(FISHING_ROD, true);
        setBooleanSetting(LEVEL_2_POTIONS, true);
        setBooleanSetting(GOLDEN_APPLE_ON_KILL, true);
        setIntegerSettings(DIAMOND_ARMORS_LIMIT, 4);
        setIntegerSettings(DIAMOND_LIMIT, 0);
        setIntegerSettings(EnchantsLimits.SHARPNESS, 5);
        setIntegerSettings(EnchantsLimits.FIRE_ASPECT, 2);
        setIntegerSettings(EnchantsLimits.KNOCKBACK, 2);
        setIntegerSettings(EnchantsLimits.THORNS, 3);
        setIntegerSettings(EnchantsLimits.FEATHER_FALLING, 4);
        setIntegerSettings(EnchantsLimits.DEPTH_STRIDER, 3);
        setIntegerSettings(EnchantsLimits.INFINITY, 1);
        setIntegerSettings(EnchantsLimits.FLAME, 1);
        setIntegerSettings(EnchantsLimits.PUNCH, 2);
    }

    public static String redIfZero(String setting) {
        return (getIntegerSetting(setting) == 0) ? String.valueOf(ChatColor.RED) : "";
    }

    public static void clickIntSetting(InventoryClickEvent event, String setting, int min_value, int max_value) {
        if (event.getClick().equals(ClickType.LEFT) && getIntegerSetting(setting) > min_value) {
            addIntegerSetting(setting, -1);
        }
        if (event.getClick().equals(ClickType.RIGHT) && getIntegerSetting(setting) < max_value) {
            addIntegerSetting(setting, 1);
        }
    }

    public static void clickIntSetting(InventoryClickEvent event, String setting, int max_value) {
        clickIntSetting(event, setting, 0, max_value);
    }
}
