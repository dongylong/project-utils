package com.latte.utils;

import java.math.BigDecimal;

public class CalculateUtils {

    public static Double cal(Integer a1, Integer a2) {
        if (a2 == 0) {
            return 0.0;
        }
        return BigDecimal.valueOf((float) a1 / a2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
