package com.air_research.airwarningsystem.lhasa.service.impl;

import com.air_research.airwarningsystem.lhasa.entity.LhasaAirPollutantsConcentration;
import com.air_research.airwarningsystem.lhasa.mapper.LhasaAirPollutantsConcentrationMapper;
import com.air_research.airwarningsystem.lhasa.service.ILhasaAirPollutantsConcentrationService;
import com.air_research.airwarningsystem.util.ResultProUtil;
import com.air_research.airwarningsystem.vo.AirPollutantVO;
import com.air_research.airwarningsystem.vo.AirPollutantsConcentrationVO;
import com.air_research.airwarningsystem.vo.AirQualityVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Wilson Zhang
 * @since 2022-05-17
 */
@Service
public class LhasaAirPollutantsConcentrationServiceImpl extends ServiceImpl<LhasaAirPollutantsConcentrationMapper, LhasaAirPollutantsConcentration> implements ILhasaAirPollutantsConcentrationService {

    @Autowired
    private LhasaAirPollutantsConcentrationMapper mapper;

    @Autowired
    private DateTimeFormatter formatter;

    /**
     * 某日的空气污染物浓度预测值及相应的空气质量等级
     * @param date 某日
     * @return
     */
    public LhasaAirPollutantsConcentration getByDate(String date) {
        LhasaAirPollutantsConcentration res = null;
        LocalDate predDate = LocalDate.parse(date, formatter);

        res = mapper.selectOne(
                new QueryWrapper<LhasaAirPollutantsConcentration>().eq("pred_date", predDate));

        if (res == null) {
            res = new LhasaAirPollutantsConcentration(predDate,
                    0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "0");
        }

        return res;
    }

    /**
     * 指定日期间隔内，空气污染物浓度预测值及相应的空气质量等级历史数据
     * @param fromDate 起始日期
     * @param toDate 终止日期
     * @return
     */
    public List<AirPollutantsConcentrationVO> getFromDates(String fromDate, String toDate) {
        List<AirPollutantsConcentrationVO> res = null;
        LocalDate dateFrom = LocalDate.parse(fromDate, formatter);
        LocalDate dateTo = LocalDate.parse(toDate, formatter);

        res = mapper.getFromDates(dateFrom, dateTo);
        //按照日期升序排序
        ResultProUtil.sortAirPollutantsConcentrationQuality(res);
        //填充未匹配日期数据
        ResultProUtil.airPollutantsConcentrationQualitySupplement(res, dateFrom, dateTo);

        return res;
    }

    /**
     * 查询某污染物于指定日期间隔内的历史浓度
     * @param pollutant 某污染物
     * @param fromDate 起始日期
     * @param toDate 终止日期
     * @return
     */
    public List<AirPollutantVO> getByPollutant(String pollutant, String fromDate, String toDate) {
        List<AirPollutantVO> res = null;
        LocalDate dateFrom = LocalDate.parse(fromDate, formatter);
        LocalDate dateTo = LocalDate.parse(toDate, formatter);

        res = mapper.getByPollutant(pollutant, dateFrom, dateTo);
        //按照日期升序排序
        ResultProUtil.sortAirPollutantList(res);
        //填充未匹配日期数据
        ResultProUtil.airPollutantConcentrationSupplement(res, dateFrom, dateTo);

        return res;
    }

    /**
     * 指定日期间隔内，查询空气质量等级历史数据
     * @param fromDate 起始日期
     * @param toDate 终止日期
     * @return
     */
    public List<AirQualityVO> getAirQuality(String fromDate, String toDate) {
        List<AirQualityVO> res = null;
        LocalDate dateFrom = LocalDate.parse(fromDate, formatter);
        LocalDate dateTo = LocalDate.parse(toDate, formatter);

        res = mapper.getAirQuality(dateFrom, dateTo);
        //按照日期升序排序
        ResultProUtil.sortAirQualityList(res);
        //填充未匹配日期数据
        ResultProUtil.airQualitySupplement(res, dateFrom, dateTo);

        return res;
    }
}
