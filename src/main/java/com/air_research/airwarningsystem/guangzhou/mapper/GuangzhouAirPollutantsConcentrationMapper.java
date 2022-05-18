package com.air_research.airwarningsystem.guangzhou.mapper;

import com.air_research.airwarningsystem.guangzhou.entity.GuangzhouAirPollutantsConcentration;
import com.air_research.airwarningsystem.vo.AirPollutantVO;
import com.air_research.airwarningsystem.vo.AirPollutantsConcentrationVO;
import com.air_research.airwarningsystem.vo.AirQualityVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Wilson Zhang
 * @since 2022-05-17
 */
public interface GuangzhouAirPollutantsConcentrationMapper extends BaseMapper<GuangzhouAirPollutantsConcentration> {

    /**
     * 指定日期间隔内，查看某空气污染物历史浓度
     * @param pollutant 某空气污染物
     * @param fromDate 起始日期
     * @param toDate 终止日期
     * @return
     */
    List<AirPollutantVO> getByPollutant(String pollutant, LocalDate fromDate, LocalDate toDate);

    /**
     * 指定日期间隔内，查看空气质量等级历史数据
     * @param fromDate 起始日期
     * @param toDate 终止日期
     * @return
     */
    List<AirQualityVO> getAirQuality(LocalDate fromDate, LocalDate toDate);

    /**
     * 指定日期间隔内，查看空气污染物浓度和空气质量等级历史数据
     * @param fromDate 起始日期
     * @param toDate 终止日期
     * @return
     */
    @Select("select pred_date as 'predDate', pm25 as 'pm25', pm10 as 'pm10', " +
            "so2 as 'so2', co as 'co', no2 as 'no2', o3 as 'o3', aq_level as 'aqLevel' " +
            "from tb_guangzhou_air_pollutants_concentration " +
            "where pred_date >= #{fromDate} and pred_date <= #{toDate}")
    List<AirPollutantsConcentrationVO> getFromDates(LocalDate fromDate, LocalDate toDate);
}
