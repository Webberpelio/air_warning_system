package com.air_research.airwarningsystem.lanzhou.controller;


import com.air_research.airwarningsystem.lanzhou.entity.LanzhouAirPollutantsConcentration;
import com.air_research.airwarningsystem.lanzhou.service.impl.LanzhouAirPollutantsConcentrationServiceImpl;
import com.air_research.airwarningsystem.vo.AirPollutantVO;
import com.air_research.airwarningsystem.vo.AirPollutantsConcentrationVO;
import com.air_research.airwarningsystem.vo.AirQualityVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Wilson Zhang
 * @since 2022-05-17
 */
@Api(tags = "空气污染物浓度和空气质量等级信息获取API")
@Controller
@RequestMapping("/lanzhou-air-pollutants-concentration")
public class LanzhouAirPollutantsConcentrationController {

    @Autowired
    private LanzhouAirPollutantsConcentrationServiceImpl service;

    @ApiOperation("空气污染物浓度和空气质量等级预测结果")
    @GetMapping("/get_by_date")
    public String getByDate(String date, Model model) {
        LanzhouAirPollutantsConcentration res = service.getByDate(date);

        model.addAttribute("city", "兰州");
        model.addAttribute("res", res);

        return "display";
    }

    @ApiOperation("空气污染物浓度和空气质量等级历史预测数据")
    @GetMapping("/get_from_dates")
    public String getFromDates(String fromDate, String toDate, Model model) {
        List<AirPollutantsConcentrationVO> res = service.getFromDates(fromDate, toDate);

        model.addAttribute("city", "兰州");
        model.addAttribute("res", res);

        return "air_info";
    }

    @ApiOperation("某空气污染物浓度历史数据")
    @GetMapping("/get_by_pollutant")
    public String getByPollutant(String pollutant, String fromDate, String toDate, Model model) {
        List<AirPollutantVO> res = service.getByPollutant(pollutant, fromDate, toDate);

        model.addAttribute("city", "兰州");
        model.addAttribute("pollutant", pollutant);
        model.addAttribute("res", res);

        return "pollutant_info";
    }

    @ApiOperation("空气质量等级历史数据")
    @GetMapping("/get_air_quality")
    public String getAirQuality(String fromDate, String toDate, Model model) {
        List<AirQualityVO> res = service.getAirQuality(fromDate, toDate);

        model.addAttribute("city", "兰州");
        model.addAttribute("res", res);

        return "air_quality_level_info";
    }
}

