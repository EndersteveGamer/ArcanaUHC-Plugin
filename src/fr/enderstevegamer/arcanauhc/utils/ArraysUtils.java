package fr.enderstevegamer.arcanauhc.utils;

public class ArraysUtils {
    public static <T> T[] invertArray(T[] array) {
        T[] result = array.clone();
        for (int i = 0; i < array.length; i++) {
            result[result.length - i - 1] = array[i];
        }
        return result;
    }
}
