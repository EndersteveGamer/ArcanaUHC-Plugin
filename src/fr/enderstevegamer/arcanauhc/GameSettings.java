package fr.enderstevegamer.arcanauhc;

import java.util.HashMap;

public class GameSettings {
    public static String DIAMOND_HELMET = "diamond_helmet";
    public static String DIAMOND_CHESTPLATE = "diamond_chestplate";
    public static String DIAMOND_LEGGINGS = "diamond_leggings";
    public static String DIAMOND_BOOTS = "diamond_boots";
    public static String DIAMOND_SWORDS = "diamond_swords";
    public static String ENCHANTMENT_TABLES = "enchantment_tables";
    public static String LAVA_BUCKETS = "lava_buckets";
    public static String ENDER_PEARLS = "ender_pearls";
    public static String BREWING_STANDS = "brewing_stands";
    public static String BOWS = "bows";
    public static String BOOKSHELVES = "bookshelves";
    public static String FLINT_AND_STEEL = "flint_and_steel";
    public static String FISHING_ROD = "fishing_rod";
    public static String LEVEL_2_POTIONS = "level_2_potions";
    public static String DIAMOND_ARMORS_LIMIT = "diamond_armors_limit";
    public static String DIAMOND_LIMIT = "diamond_limit";
    public static String GOLDEN_APPLE_ON_KILL = "golden_apple_on_kill";

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
    }
}
