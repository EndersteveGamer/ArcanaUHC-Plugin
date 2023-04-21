package fr.enderstevegamer.arcanauhc.utils;

import org.bukkit.Location;

public class LocationUtils {
    public static double distanceToLocation(Location loc1, Location loc2) {
        return Math.sqrt(
                (loc2.getX() - loc1.getX()) * (loc2.getX() - loc1.getX()) +
                (loc2.getY() - loc1.getY()) * (loc2.getY() - loc1.getY()) +
                (loc2.getZ() - loc1.getZ()) * (loc2.getZ() - loc1.getZ())
        );
    }
}
