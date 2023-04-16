package fr.enderstevegamer.arcanauhc.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtils {
    public static double round(float number, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(number));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
