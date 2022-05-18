package com.air_research.airwarningsystem.util;

import com.air_research.airwarningsystem.vo.AirPollutantVO;
import com.air_research.airwarningsystem.vo.AirPollutantsConcentrationVO;
import com.air_research.airwarningsystem.vo.AirQualityVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zwell
 */
public class ResultProUtil {

    /**
     * 检索结果返回前处理工具
     */

    /**
     * 根据predDate和postDate之间的日期间隔数，生成默认的空气污染物历史浓度记录
     * @param preDate
     * @param postDate
     * @param head 标记，该值为true时补足头部，否则补足尾部
     * @return
     */
    private static List<AirPollutantsConcentrationVO> supplyAirPollutantsConcentrationQuality(LocalDate preDate, LocalDate postDate, boolean head) {
        List<AirPollutantsConcentrationVO> res = new ArrayList<>();
        //间隔日数
        long dateSpan = DateProUtil.dateSpan(preDate, postDate);
        int start = 0;

        if (head) {
            //如果要补足头部，则需从predDate起至predDate+dateSpan-1止
            dateSpan -= 1;
        } else {
            //如果是补足尾部，则需从predDate+1起至predDate+dateSpan止
            start += 1;
        }

        for (int i = start; i <= dateSpan; i++) {
            res.add(new AirPollutantsConcentrationVO(preDate.plusDays(i),
                    0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "0"));
        }

        return res;
    }

    /**
     * 以起始日期和终止日期为界，补全容器中缺失日期的数据--空气污染物历史浓度和对应的空气质量等级历史数据
     * @param res 待填充的容器
     * @param fromDate 起始日期
     * @param toDate 终止日期
     */
    public static void airPollutantsConcentrationQualitySupplement(List<AirPollutantsConcentrationVO> res,
                                                                   LocalDate fromDate, LocalDate toDate) {
        if (res.size() == 0) {
            res.addAll(0, ResultProUtil.supplyAirPollutantsConcentrationQuality(fromDate, toDate.plusDays(1), true));
            return;
        }

        if (res.get(0).getPredDate().isAfter(fromDate)) {
            res.addAll(0,
                    ResultProUtil.supplyAirPollutantsConcentrationQuality(fromDate, res.get(0).getPredDate(), true));
        }

        if (res.get(res.size() - 1).getPredDate().isBefore(toDate)) {
            res.addAll(res.size(),
                    ResultProUtil.supplyAirPollutantsConcentrationQuality(res.get(res.size() - 1).getPredDate(), toDate, false));
        }
    }

    /**
     * 根据predDate和postDate之间的日期间隔数，生成默认的某空气污染物历史浓度记录
     * @param preDate
     * @param postDate
     * @param head 标记，该值为true时补足头部，否则补足尾部
     * @return
     */
    private static List<AirPollutantVO> supplyAirPollutantConcentration(LocalDate preDate, LocalDate postDate, boolean head) {
        List<AirPollutantVO> res = new ArrayList<>();
        long dateSpan = DateProUtil.dateSpan(preDate, postDate);
        int start = 0;

        if (head) {
            //如果要补足头部，则需从predDate起至predDate+dateSpan-1止
            dateSpan -= 1;
        } else {
            //如果是补足尾部，则需从predDate+1起至predDate+dateSpan止
            start += 1;
        }

        for (int i = start; i <= dateSpan; i++) {
            res.add(new AirPollutantVO(preDate.plusDays(i), 0.0));
        }

        return res;
    }

    /**
     * 以起始日期和终止日期为界，补全容器中缺失日期的数据--某空气污染物历史浓度
     * @param res 待填充容器
     * @param fromDate 起始日期
     * @param toDate 终止日期
     */
    public static void airPollutantConcentrationSupplement(List<AirPollutantVO> res, LocalDate fromDate, LocalDate toDate) {
        if (res.size() == 0) {
            res.addAll(0, ResultProUtil.supplyAirPollutantConcentration(fromDate, toDate.plusDays(1), true));
            return;
        }

        if (res.get(0).getDate().isAfter(fromDate)) {
            res.addAll(0, ResultProUtil.supplyAirPollutantConcentration(fromDate, res.get(0).getDate(), true));
        }

        if (res.get(res.size() - 1).getDate().isBefore(toDate)) {
            res.addAll(res.size(), ResultProUtil.supplyAirPollutantConcentration(res.get(res.size() - 1).getDate(), toDate, false));
        }
    }

    /**
     * 根据predDate和postDate之间的日期间隔数，生成默认的空气质量等级记录
     * @param preDate
     * @param postDate
     * @param head 标记，该值为true时补足头部，否则补足尾部
     * @return
     */
    private static List<AirQualityVO> supplyAirQuality(LocalDate preDate, LocalDate postDate, boolean head) {
        List<AirQualityVO> res = new ArrayList<>();
        long dateSpan = DateProUtil.dateSpan(preDate, postDate);
        int start = 0;

        if (head) {
            //如果要补足头部，则需从predDate起至predDate+dateSpan-1止
            dateSpan -= 1;
        } else {
            //如果是补足尾部，则需从predDate+1起至predDate+dateSpan止
            start += 1;
        }

        for (int i = start; i <= dateSpan; i++) {
            res.add(new AirQualityVO(preDate.plusDays(i), "0"));
        }

        return res;
    }

    /**
     * 以起始日期和终止日期为界，补全容器中缺失日期的数据--空气质量等级历史数据
     * @param res 带填充容器
     * @param fromDate 起始日期
     * @param toDate 终止日期
     */
    public static void airQualitySupplement(List<AirQualityVO> res, LocalDate fromDate, LocalDate toDate) {
        if (res.size() == 0) {
            res.addAll(0, ResultProUtil.supplyAirQuality(fromDate, toDate.plusDays(1), true));
            return;
        }

        if (res.get(0).getDate().isAfter(fromDate)) {
            res.addAll(0, ResultProUtil.supplyAirQuality(fromDate, res.get(0).getDate(), true));
        }

        if (res.get(res.size() - 1).getDate().isBefore(toDate)) {
            res.addAll(res.size(), ResultProUtil.supplyAirQuality(res.get(res.size() - 1).getDate(), toDate, false));
        }
    }

    /**
     * 按照日期升序排序
     * @param res 待排序的容器
     */
    public static void sortAirPollutantList(List<AirPollutantVO> res) {
        res.sort(new Comparator<AirPollutantVO>() {
            @Override
            public int compare(AirPollutantVO ones, AirPollutantVO another) {
                return (int) (-DateProUtil.dateSpan(ones.getDate(), another.getDate()));
            }
        });
    }

    /**
     * 按照日期升序排序
     * @param res 待排序的容器
     */
    public static void sortAirQualityList(List<AirQualityVO> res) {
        res.sort(new Comparator<AirQualityVO>() {
            @Override
            public int compare(AirQualityVO ones, AirQualityVO another) {
                return (int) (-DateProUtil.dateSpan(ones.getDate(), another.getDate()));
            }
        });
    }

    /**
     * 按照日期升序排序
     * @param res 待排序的容器
     */
    public static void sortAirPollutantsConcentrationQuality(List<AirPollutantsConcentrationVO> res) {
        res.sort(new Comparator<AirPollutantsConcentrationVO>() {
            @Override
            public int compare(AirPollutantsConcentrationVO ones, AirPollutantsConcentrationVO another) {
                return (int) (-DateProUtil.dateSpan(ones.getPredDate(), another.getPredDate()));
            }
        });
    }
}
