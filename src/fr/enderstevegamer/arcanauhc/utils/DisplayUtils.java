package fr.enderstevegamer.arcanauhc.utils;

import javafx.util.Duration;

public class DisplayUtils {
    public static String minutesToTimeString(int minutes) {
        if (minutes < 60) return minutes + "m";
        else if (minutes % 60 == 0) return (minutes / 60) + "h";
        else return (minutes / 60) + "h" + (minutes % 60) + "m";
    }

    public static String millisecondsToTimeString(long milliseconds) {
        long hours = milliseconds / (60000 * 60);
        long minutes = milliseconds / 60000 - hours * 60;
        long seconds = milliseconds / 1000 - minutes * 60 - hours * 3600;
        long remainingMilliseconds = milliseconds - hours * (60000 * 60) - minutes * 60000 - seconds * 1000;
        if (hours == 0 && minutes == 0 && seconds == 0) return remainingMilliseconds + "ms";
        StringBuilder str = new StringBuilder();
        if (hours != 0) str.append(hours).append("h");
        if (minutes != 0) str.append((minutes < 10 && hours != 0) ? "0" : "").append(minutes).append("m");
        if (seconds != 0) str.append((seconds < 10 && minutes != 0) ? "0" : "").append(seconds).append("s");
        return addTimeSpaces(str.toString());
    }

    private static String addTimeSpaces(String str) {
        StringBuilder finalStr = new StringBuilder();
        for (int i = 0; i < str.toCharArray().length; i++) {
            if (str.toCharArray()[i] == 'h' && i != str.toCharArray().length - 1) finalStr.append("h ");
            else if (str.toCharArray()[i] == 'm' && i != str.toCharArray().length - 1) finalStr.append("m ");
            else if (str.toCharArray()[i] == 's' && i != str.toCharArray().length - 1) finalStr.append("s ");
            else finalStr.append(str.toCharArray()[i]);
        }
        return finalStr.toString();
    }
}
