package com.air_research.airwarningsystem.guangzhou.service.impl;

import com.air_research.airwarningsystem.guangzhou.entity.GuangzhouAirPollutantsConcentration;
import com.air_research.airwarningsystem.guangzhou.mapper.GuangzhouAirPollutantsConcentrationMapper;
import com.air_research.airwarningsystem.guangzhou.service.IGuangzhouAirPollutantsConcentrationService;
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
public class GuangzhouAirPollutantsConcentrationServiceImpl extends ServiceImpl<GuangzhouAirPollutantsConcentrationMapper, GuangzhouAirPollutantsConcentration> implements IGuangzhouAirPollutantsConcentrationService {

    @Autowired
    private GuangzhouAirPollutantsConcentrationMapper mapper;

    @Autowired
    private DateTimeFormatter formatter;

    /**
     * 查看某日空气污染物浓度预测值
     * @param date 某日
     * @return
     */
    public GuangzhouAirPollutantsConcentration getByDate(String date) {
        GuangzhouAirPollutantsConcentration res = null;
        LocalDate predDate = LocalDate.parse(date, formatter);

        res = mapper.selectOne(new QueryWrapper<GuangzhouAirPollutantsConcentration>()
                .eq("pred_date", predDate));

        if (res == null) {
            res = new GuangzhouAirPollutantsConcentration(predDate,
                    0.0, 0.0, 0.0, 0.0, 0.0, 0.0, "0");
        }

        return res;
    }

    /**
     * 指定日期间隔内，查看空气污染物浓度历史数据
     * @param fromDate  起始日期
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
     * 指定日期间隔内，查看某空气污染物浓度历史数据
     * @param pollutant 某空气污染物
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
     * 指定日期间隔内，查看空气质量等级历史数据
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
