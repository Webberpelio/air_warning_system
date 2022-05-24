package com.air_research.airwarningsystem.util;

import java.util.Locale;

/**
 * @author zwell
 */
public class PollutantNameTransUtil {

    /**
     * 将污染物名字由小写形式转换为大写形式
     * @param pollutant 污染物名字
     * @return
     */
    public static String transName(String pollutant) {
        if (pollutant.equals("pm25")) {
            return "PM2.5";
        }

        return pollutant.toUpperCase();
    }
}
