package com.air_research.airwarningsystem.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author zwell
 */
public class DateProUtil {

    /**
     * 检查查询日期间隔与实际所得结果日期间隔是否一致，若不一致则不补全之
     */

    /**
     * 计算preDate与postDate之间的间隔天数
     * @param preDate
     * @param postDate
     * @return
     */
    public static long dateSpan(LocalDate preDate, LocalDate postDate) {
        return preDate.until(postDate, ChronoUnit.DAYS);
    }
}
