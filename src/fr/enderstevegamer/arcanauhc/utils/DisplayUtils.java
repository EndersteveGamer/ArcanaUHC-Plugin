package fr.enderstevegamer.arcanauhc.utils;

public class DisplayUtils {
    public static String minutesToTimeString(int minutes) {
        if (minutes < 60) return minutes + "m";
        else if (minutes % 60 == 0) return (minutes / 60) + "h";
        else return (minutes / 60) + "h" + (minutes % 60) + "m";
    }
}
