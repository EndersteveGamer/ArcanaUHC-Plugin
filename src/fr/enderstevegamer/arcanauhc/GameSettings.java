package fr.enderstevegamer.arcanauhc;

import org.bukkit.ChatColor;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

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
    public static final String BOWS = "bows";
    public static final String BOOKSHELVES = "bookshelves";
    public static final String FLINT_AND_STEEL = "flint_and_steel";
    public static final String FISHING_ROD = "fishing_rod";
    public static final String DIAMOND_ARMORS_LIMIT = "diamond_armors_limit";
    public static final String DIAMOND_LIMIT = "diamond_limit";
    public static final String GOLDEN_APPLE_ON_KILL = "golden_apple_on_kill";
    public static final String COMPLETE_RANDOM_ARCANE = "complete_with_random_arcane";
    public static final String DEFAULT_BORDER_SIZE = "default_border_size";
    public static final String FINAL_BORDER_SIZE = "final_border_size";
    public static final String BORDER_WAIT_TIME = "border_wait_time";
    public static final String BORDER_REDUCTION_TIME = "border_reduction_time";
    public static final String SERVER_SLOTS = "server_slots";
    public static final String SPECTATORS_CAN_JOIN = "spectators_can_join";
    public static final String HEALTH_IN_TAB = "health_in_tab";
    public static final String FINAL_HEAL = "final_heal";
    public static final String TIME_BEFORE_PVP = "time_before_pvp";
    public static final String LIFE_UNDER_NAME = "life_under_name";
    public static final String XP_RATE = "xp_rate";
    public static final String FLINT_DROP = "flint_drop";
    public static final String APPLES_DROP = "apples_drop";
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
    public static class Scenarios {
        public static final String BETA_ZOMBIE = "beta_zombie";
        public static final String HASTEY_BOYS = "hastey_boys";
        public static final String TIMBER = "timber";
        public static final String FAST_LEAVES_DECAY = "fast_leaves_decay";
        public static final String NO_DEATH_BEFORE_PVP = "no_death_before_pvp";
        public static final String SAFE_MINERS = "safe_miners";
    }


    public static HashMap<Arcane, Integer> arcanesNumbers = new HashMap<>();
    public static HashMap<String, Boolean> booleanSettings = new HashMap<>();
    public static HashMap<String, Integer> integerSettings = new HashMap<>();
    public static ItemStack[] startingArmor = new ItemStack[4];
    public static ItemStack[] startingInventory = new ItemStack[36];
    public static String gameName = "Arcana UHC";

    public static void setBooleanSetting(String setting, boolean value) {
        booleanSettings.put(setting, value);
    }

    public static boolean getBooleanSetting(String setting) {
        return booleanSettings.get(setting);
    }

    public static void toggleBooleanSetting(String setting) {
        setBooleanSetting(setting, !getBooleanSetting(setting));
    }

    public static void setIntegerSetting(String setting, int value) {
        integerSettings.put(setting, value);
    }

    public static int getIntegerSetting(String setting) {
        return integerSettings.get(setting);
    }

    public static void addIntegerSetting(String setting, int value) {
        setIntegerSetting(setting, getIntegerSetting(setting) + value);
    }

    public static ItemStack[] getStartingArmor() {
        return startingArmor;
    }

    public static ItemStack[] getStartingInventory() {
        return startingInventory;
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
        setBooleanSetting(BOWS, true);
        setBooleanSetting(BOOKSHELVES, true);
        setBooleanSetting(FLINT_AND_STEEL, true);
        setBooleanSetting(FISHING_ROD, true);
        setBooleanSetting(GOLDEN_APPLE_ON_KILL, true);
        setBooleanSetting(COMPLETE_RANDOM_ARCANE, false);
        setIntegerSetting(DIAMOND_ARMORS_LIMIT, 4);
        setIntegerSetting(DIAMOND_LIMIT, 30);
        setIntegerSetting(EnchantsLimits.SHARPNESS, 5);
        setIntegerSetting(EnchantsLimits.FIRE_ASPECT, 2);
        setIntegerSetting(EnchantsLimits.KNOCKBACK, 2);
        setIntegerSetting(EnchantsLimits.THORNS, 3);
        setIntegerSetting(EnchantsLimits.FEATHER_FALLING, 4);
        setIntegerSetting(EnchantsLimits.DEPTH_STRIDER, 3);
        setIntegerSetting(EnchantsLimits.INFINITY, 1);
        setIntegerSetting(EnchantsLimits.FLAME, 1);
        setIntegerSetting(EnchantsLimits.PUNCH, 2);
        setIntegerSetting(DEFAULT_BORDER_SIZE, 1000);
        setIntegerSetting(FINAL_BORDER_SIZE, 250);
        setIntegerSetting(BORDER_REDUCTION_TIME, 20);
        setIntegerSetting(BORDER_WAIT_TIME, 90);
        resetStartingStuff();
        resetArcanes();
        setBooleanSetting(Scenarios.BETA_ZOMBIE, false);
        setBooleanSetting(Scenarios.HASTEY_BOYS, false);
        setBooleanSetting(Scenarios.TIMBER, false);
        setBooleanSetting(Scenarios.FAST_LEAVES_DECAY, false);
        setBooleanSetting(Scenarios.NO_DEATH_BEFORE_PVP, false);
        setBooleanSetting(Scenarios.SAFE_MINERS, false);
        gameName = "Arcana UHC";
        setIntegerSetting(SERVER_SLOTS, 20);
        setBooleanSetting(SPECTATORS_CAN_JOIN, true);
        setBooleanSetting(HEALTH_IN_TAB, false);
        setIntegerSetting(FINAL_HEAL, 20);
        setIntegerSetting(TIME_BEFORE_PVP, 20);
        setBooleanSetting(LIFE_UNDER_NAME, false);
        setIntegerSetting(XP_RATE, 150);
        setIntegerSetting(FLINT_DROP, 10);
        setIntegerSetting(APPLES_DROP, 5);
    }

    public static void resetStartingStuff() {
        Arrays.fill(startingArmor, null);
        Arrays.fill(startingInventory, null);
    }

    public static void resetArcanes() {
        setArcane(Arcane.BATELEUR, 1);
        setArcane(Arcane.PAPESSE, 1);
        setArcane(Arcane.IMPERATRICE, 1);
        setArcane(Arcane.EMPEREUR, 1);
        setArcane(Arcane.PAPE, 1);
        setArcane(Arcane.AMOUREUX, 1);
        setArcane(Arcane.CHARIOT, 1);
        setArcane(Arcane.JUSTICE, 1);
        setArcane(Arcane.HERMITE, 1);
        setArcane(Arcane.ROUE_DE_LA_FORTUNE, 1);
        setArcane(Arcane.FORCE, 1);
        setArcane(Arcane.PENDU, 1);
        setArcane(Arcane.SANS_NOM, 1);
        setArcane(Arcane.TEMPERANCE, 1);
        setArcane(Arcane.DIABLE, 1);
        setArcane(Arcane.MAISON_DIEU, 1);
        setArcane(Arcane.ETOILE, 1);
        setArcane(Arcane.LUNE, 1);
        setArcane(Arcane.SOLEIL, 1);
        setArcane(Arcane.JUGEMENT, 1);
        setArcane(Arcane.MONDE, 1);
        setArcane(Arcane.MAT, 1);
        setArcane(Arcane.SANS_ARCANE, 1);
    }

    public static void addToArcane(Arcane arcane, int value) {
        setArcane(arcane, getArcane(arcane) + value);
    }

    public static void addToAllArcanes(int value) {
        for (Arcane arcane : arcanesNumbers.keySet()) {
            if (getArcane(arcane) + value >= 0) {
                addToArcane(arcane, value);
            }
        }
    }

    public static void setArcane(Arcane arcane, int value) {
        arcanesNumbers.put(arcane, value);
    }

    public static int getArcane(Arcane arcane){
        return arcanesNumbers.get(arcane);
    }

    public static int getTotalArcaneNumber() {
        int total = 0;
        for (Arcane arcane : arcanesNumbers.keySet()) {
            total += getArcane(arcane);
        }
        return total;
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

    public static void clickIntSetting(InventoryClickEvent event, String setting, int min_value, int max_value, int increment) {
        if (event.getClick().equals(ClickType.LEFT) && getIntegerSetting(setting) - increment >= min_value) {
            addIntegerSetting(setting, -increment);
        }
        if (event.getClick().equals(ClickType.RIGHT) && getIntegerSetting(setting) + increment <= max_value) {
            addIntegerSetting(setting, increment);
        }
    }

    public static void clickIntSetting(InventoryClickEvent event, String setting, int max_value) {
        clickIntSetting(event, setting, 0, max_value);
    }

    public static void clickTeamSetting(InventoryClickEvent event, int slot, Arcane arcane) {
        if (event.getSlot() != slot) return;
        if (event.getClick().equals(ClickType.LEFT) && getArcane(arcane) > 0) {
            addToArcane(arcane, -1);
        }
        if (event.getClick().equals(ClickType.RIGHT)) {
            addToArcane(arcane, 1);
        }
    }
}
