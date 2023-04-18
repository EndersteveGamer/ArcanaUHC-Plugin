package fr.enderstevegamer.arcanauhc;

import fr.enderstevegamer.arcanauhc.utils.AmoureuxLink;
import fr.enderstevegamer.arcanauhc.utils.MathUtils;
import fr.enderstevegamer.arcanauhc.utils.PlayerUtils;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;

public class GameState {
    private static boolean gameStarted;
    private static boolean pvpEnabled;
    private static long startTime;
    private static boolean isPregenerating;
    private static HashMap<UUID, Arcane> playerArcanes;
    private static ArrayList<UUID> alivePlayers;
    private static boolean finalHealGiven;
    private static boolean wasBorderReduced;
    private static boolean arcanesGiven;
    private static int infiniteTime;
    private static HashMap<UUID, Long> imperatriceCooldown;
    private static HashMap<UUID, Long> amoureuxCooldown;
    private static long papeCooldown;
    private static HashMap<UUID, UUID> amoureuxSnowballs;
    private static ArrayList<AmoureuxLink> amoureuxLinks;
    private static ArrayList<UUID> murderers;
    private static long hermitesCooldown;
    private static boolean hermiteOnSpeed;
    private static long roueDeLaFortuneCooldown;
    private static HashMap<UUID, Integer[]> roueDeLaFortuneEffects;
    private static HashMap<UUID, Long> penduImmobilized;

    public static void penduImmobilize(Player player) {
        penduImmobilized.put(player.getUniqueId(), System.currentTimeMillis());
    }

    public static Integer[] getRoueDeLaFortuneEffects(Player player) {
        return roueDeLaFortuneEffects.get(player.getUniqueId());
    }

    public static void updateRoueDeLaFortune() {
        if (System.currentTimeMillis() - roueDeLaFortuneCooldown >= 5 * 60 * 1000) {
            setRoueDeLaFortuneEffects();
            roueDeLaFortuneCooldown = System.currentTimeMillis();
        }
    }

    public static void setRoueDeLaFortuneEffects() {
        for (Player player : getAllPlayersWithArcane(Arcane.ROUE_DE_LA_FORTUNE)) {
            Integer[] effects = new Integer[2];
            effects[0] = (int) (Math.random() * 11);
            effects[1] = (int) (Math.random() * 11);
            while (effects[1].equals(effects[0])
                    || (effects[0] == 0 && effects[1] == 7)
                    || (effects[0] == 1 && effects[1] == 10)
                    || (effects[0] == 3 && effects[1] == 8)
                    || (effects[0] == 4 && effects[1] == 9)
            ) {
                effects[1] = (int) (Math.random() * 11);
            }
            roueDeLaFortuneEffects.put(player.getUniqueId(), effects);
        }
    }

    public static ArrayList<Player> getAllPlayersWithArcane(Arcane arcane) {
        ArrayList<Player> result = new ArrayList<>();
        for (UUID uuid : getAlivePlayers()) {
            Player player = Bukkit.getPlayer(uuid);
            if (getPlayerArcane(player).equals(arcane)) result.add(player);
        }
        return result;
    }

    public static boolean isHermiteOnSpeed() {
        return hermiteOnSpeed;
    }

    public static void updateHermites() {
        if (isHermitesCooldownFinished()) {
            hermiteOnSpeed = !hermiteOnSpeed;
            resetHermitesCooldown();
        }
    }

    public static boolean isHermitesCooldownFinished() {
        return System.currentTimeMillis() - hermitesCooldown >= 5 * 60 * 1000;
    }

    public static void resetHermitesCooldown() {
        hermitesCooldown = System.currentTimeMillis();
    }

    public static void addNewMurderer(Player player) {
        murderers.add(player.getUniqueId());
    }

    public static boolean isInnocent(Player player) {
        return !murderers.contains(player.getUniqueId());
    }

    public static void updateAmoureuxLinks() {
        ArrayList<AmoureuxLink> toRemove = new ArrayList<>();
        for (AmoureuxLink link : amoureuxLinks) {
            if (link.linkExpired()) {
                toRemove.add(link);
                link.announceEndOfLink();
            }
        }
        amoureuxLinks.removeAll(toRemove);
    }

    public static boolean amoureuxLinkExists(UUID player1, UUID player2) {
        for (AmoureuxLink link : amoureuxLinks) {
            if (link.areLinked(player1, player2)) return true;
        }
        return false;
    }

    public static AmoureuxLink createAmoureuxLink(UUID player1, UUID player2, boolean doublePlayerLink) {
        AmoureuxLink link = new AmoureuxLink(player1, player2, doublePlayerLink);
        amoureuxLinks.add(link);
        return link;
    }

    public static void addAmoureuxSnowball(Snowball snowball, Player player) {
        amoureuxSnowballs.put(snowball.getUniqueId(), player.getUniqueId());
    }

    public static UUID amoureuxSnowballLauncher(UUID snowballUuid) {
        return amoureuxSnowballs.get(snowballUuid);
    }

    public static void deleteAmoureuxSnowball(UUID snowballUuid) {
        amoureuxSnowballs.remove(snowballUuid);
    }

    public static void resetAmoureuxCooldown(Player player) {
        amoureuxCooldown.put(player.getUniqueId(), System.currentTimeMillis());
    }

    public static boolean amoureuxCooldownFinished(Player player) {
        return (!amoureuxCooldown.containsKey(player.getUniqueId())
                || System.currentTimeMillis() - amoureuxCooldown.get(player.getUniqueId()) >= 10 * 60000);
    }

    public static long getAmoureuxCooldown(Player player) {
        return 10 * 60 - (System.currentTimeMillis() - amoureuxCooldown.get(player.getUniqueId())) / 1000;
    }

    public static boolean papeCooldownFinished() {
        return System.currentTimeMillis() - papeCooldown >= 10 * 60 * 1000;
    }

    public static void resetPapeCooldown() {
        papeCooldown = System.currentTimeMillis();
    }

    public static void resetImperatriceCooldown(Player player) {
        imperatriceCooldown.put(player.getUniqueId(), System.currentTimeMillis());
    }

    public static boolean imperatriceCooldownFinished(Player player) {
        return (!imperatriceCooldown.containsKey(player.getUniqueId())
                || System.currentTimeMillis() - imperatriceCooldown.get(player.getUniqueId()) >= 3 * 60000);
    }

    public static long getImperatriceCooldown(Player player) {
        return 3 * 60 - (System.currentTimeMillis() - imperatriceCooldown.get(player.getUniqueId())) / 1000;
    }

    public static int getInfiniteTime() {
        return infiniteTime;
    }

    public static void setInfiniteTime(int time) {
        infiniteTime = time;
    }

    public static boolean wereArcanesGiven() {
        return arcanesGiven;
    }

    public static void setArcanesGiven(boolean wereArcanesGiven) {
        arcanesGiven = wereArcanesGiven;
    }

    public static boolean wasBorderReduced() {
        return wasBorderReduced;
    }

    public static void setBorderReduced(boolean borderReduced) {
        wasBorderReduced = borderReduced;
    }

    public static boolean isFinalHealGiven() {
        return finalHealGiven;
    }

    public static void setFinalHealGiven(boolean wasFinalHealGiven) {
        finalHealGiven = wasFinalHealGiven;
    }

    public static boolean isPvpDisabled() {
        return !pvpEnabled;
    }

    public static void enablePvp() {
        pvpEnabled = true;
    }

    public static void disablePvp() {
        pvpEnabled = false;
    }

    public static long getGameTime() {
        return System.currentTimeMillis() - startTime;
    }

    public static boolean gameStarted() {
        return gameStarted;
    }

    public static void setGameStarted(boolean gameStarted) {
        GameState.gameStarted = gameStarted;
    }

    public static boolean isPregenerating() {
        return isPregenerating;
    }

    public static void resetGame() {
        setGameStarted(false);
        disablePvp();
        setGameStarted(false);
        isPregenerating = false;
        playerArcanes = new HashMap<>();
        setFinalHealGiven(false);
        alivePlayers = new ArrayList<>();
        setBorderReduced(false);
        setArcanesGiven(false);
        setInfiniteTime(0);
        imperatriceCooldown = new HashMap<>();
        resetPapeCooldown();
        amoureuxCooldown = new HashMap<>();
        amoureuxSnowballs = new HashMap<>();
        amoureuxLinks = new ArrayList<>();
        murderers = new ArrayList<>();
        hermitesCooldown = System.currentTimeMillis();
        hermiteOnSpeed = false;
        roueDeLaFortuneCooldown = System.currentTimeMillis();
        roueDeLaFortuneEffects = new HashMap<>();
        penduImmobilized = new HashMap<>();
    }

    public static void pregenerateWorld() {
        final World world = (Bukkit.getWorld("world2") != null) ? Bukkit.getWorld("world2") : new WorldCreator("world2").createWorld();
        if (world == null) {Bukkit.getLogger().log(Level.SEVERE, "Impossible de créer le monde, veuillez supprimer le monde nommé 'world2' avant de pregenerer a nouveau"); return;}
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getLogger().log(Level.INFO, "Pregeneration finie!");
            }
        }.runTaskLater(Main.getInstance(), 9500);
        for (int i = -47; i <= 47; i++) {
            final int i1 = i;
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.getLogger().log(Level.INFO, "Pregeneration " + MathUtils.round(((float)(i1 + 47) / (47 + 47) * 100), 1) + "%");
                    pregenerateZPart(world, i1);
                }
            }.runTaskLater(Main.getInstance(), (i + 47) * 100);
        }
    }

    public static void pregenerateZPart(World world, int zChunk) {
        for (int i = 0; i <= 9; i++) {
            pregeneratePart(world, i, zChunk);
        }
    }

    public static void pregeneratePart(World world, int step, int zChunk) {
        int start;
        int end;
        if (step == 0) {start = -47; end = -40;}
        else if (step == 9) {start = 41; end = 47;}
        else {start = (step - 5) * 10 + 1; end = (step - 4) * 10;}
        new BukkitRunnable() {
            final int startChunk = start;
            final int endChunk = end;
            final int zChunkPos = zChunk;
            final World world1 = world;
            @Override
            public void run() {
                for (int x = startChunk; x <= endChunk; x++) {
                    world1.loadChunk(x, zChunkPos);
                    world1.unloadChunk(x, zChunkPos);
                }
            }
        }.runTaskLater(Main.getInstance(), (long) (step * 10f));
    }

    public static void startGame() {
        resetGame();

        startTime = System.currentTimeMillis();

        setGameStarted(true);

        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().clear();
            PlayerUtils.equipStartingStuff(player);
            player.teleport(Bukkit.getWorld("world2").getHighestBlockAt(0, 0).getLocation().add(new Vector(0, 1, 0)));
            player.setHealth(player.getMaxHealth());
            player.setFoodLevel(20);
            player.setSaturation(20);
            player.setExp(0);
            player.setLevel(0);
            alivePlayers.add(player.getUniqueId());
            playerArcanes.put(player.getUniqueId(), Arcane.SANS_ARCANE);
            for (PotionEffect effect : player.getActivePotionEffects()) {
                player.removePotionEffect(effect.getType());
            }
        }

        Bukkit.getWorld("world2").getWorldBorder().setCenter(0, 0);
        Bukkit.getWorld("world2").getWorldBorder().setSize(GameSettings.getIntegerSetting(GameSettings.DEFAULT_BORDER_SIZE));
        for (Entity entity : Bukkit.getWorld("world2").getEntities()) {
            if (!(entity instanceof Player)) entity.remove();
        }

        Bukkit.getWorld("world2").setTime(0);
        Bukkit.getWorld("world2").setThundering(false);
        Bukkit.getWorld("world2").setStorm(false);
    }

    public static void distributeArcanes() {
        ArrayList<Player> players = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getGameMode().equals(GameMode.SURVIVAL)) players.add(player);
        }

        ArrayList<Arcane> arcanes = new ArrayList<>();
        for (Arcane arcane : GameSettings.arcanesNumbers.keySet()) {
            for (int i = 0; i < GameSettings.arcanesNumbers.get(arcane); i++) arcanes.add(arcane);
        }
        while (arcanes.size() < players.size()) {
            if (GameSettings.getBooleanSetting(GameSettings.COMPLETE_RANDOM_ARCANE)) {
                arcanes.add(Arcane.getRandomArcane());
            }
            else arcanes.add(Arcane.SANS_ARCANE.copy());
        }

        for (Player player : players) {
            int i = (int) (Math.random() * arcanes.size());
            playerArcanes.put(player.getUniqueId(), arcanes.get(i));
            if (arcanes.get(i).equals(Arcane.SANS_ARCANE)) {
                player.sendMessage(ChatColor.GREEN + "Vous n'avez pas reçu d'Arcane!");
            }
            else {
                player.sendMessage(ChatColor.GREEN + "Vous avez reçu l'Arcane " + ChatColor.GOLD + arcanes.get(i).toString());
                if (arcanes.get(i).equals(Arcane.AMOUREUX)) {
                    ItemStack bow = new ItemStack(Material.BOW);
                    bow.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
                    player.getInventory().addItem(bow);
                    player.sendMessage(ChatColor.GREEN + "Vous avez reçu un Arc Punch I car vous possédez l'Arcane" +
                            ChatColor.GOLD + Arcane.AMOUREUX);
                }
            }
            arcanes.remove(i);
        }
        setRoueDeLaFortuneEffects();
    }

    public static Arcane getPlayerArcane(Player player) {
        if (!playerArcanes.containsKey(player.getUniqueId())) return Arcane.SANS_ARCANE;
        return playerArcanes.get(player.getUniqueId());
    }

    public static void setPlayerArcane(UUID uuid, Arcane arcane) {
        playerArcanes.put(uuid, arcane);
    }

    public static ArrayList<UUID> getAlivePlayers() {
        ArrayList<UUID> toRemove = new ArrayList<>();
        for (UUID uuid : alivePlayers) {
            boolean contains = false;
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getGameMode().equals(GameMode.SPECTATOR)) continue;
                if (player.getUniqueId().equals(uuid)) contains = true;
            }
            if (!contains) toRemove.add(uuid);
        }
        for (UUID uuid : toRemove) alivePlayers.remove(uuid);
        return alivePlayers;
    }
}
