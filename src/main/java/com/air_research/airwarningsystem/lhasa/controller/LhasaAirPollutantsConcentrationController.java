package com.air_research.airwarningsystem.lhasa.controller;


import com.air_research.airwarningsystem.lhasa.entity.LhasaAirPollutantsConcentration;
import com.air_research.airwarningsystem.lhasa.service.impl.LhasaAirPollutantsConcentrationServiceImpl;
import com.air_research.airwarningsystem.vo.AirPollutantVO;
import com.air_research.airwarningsystem.vo.AirPollutantsConcentrationVO;
import com.air_research.airwarningsystem.vo.AirQualityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Wilson Zhang
 * @since 2022-05-17
 */
@Api(tags = "拉萨空气污染物浓度预测查访API")
@RestController
@RequestMapping("/lhasa-air-pollutants-concentration")
public class LhasaAirPollutantsConcentrationController {

    @Autowired
    private LhasaAirPollutantsConcentrationServiceImpl service;

    @Autowired
    private DateTimeFormatter formatter;

    @ApiOperation("查看空气污染物浓度")
    @GetMapping("/get_by_date")
    public LhasaAirPollutantsConcentration getByDate(String date) {
        LhasaAirPollutantsConcentration res = service.getByDate(date);

        return res;
    }

    @ApiOperation("查看时段内的空气污染物浓度")
    @GetMapping("/get_from_dates")
    public List<AirPollutantsConcentrationVO> getFromDates(String fromDate, String toDate) {
        List<AirPollutantsConcentrationVO> res = service.getFromDates(fromDate, toDate);

        return res;
    }

    @ApiOperation("查看某空气污染物的历史浓度")
    @GetMapping("/get_pollutant")
    public List<AirPollutantVO> getByPollutant(String pollutant, String fromDate, String toDate) {
        List<AirPollutantVO> res = service.getByPollutant(pollutant, fromDate, toDate);

        return res;
    }

    @ApiOperation("查看空气质量等级历史数据")
    @GetMapping("/get_air_quality")
    public List<AirQualityVO> getAirQuality(String fromDate, String toDate) {
        List<AirQualityVO> res = service.getAirQuality(fromDate, toDate);

        return res;
    }
}

