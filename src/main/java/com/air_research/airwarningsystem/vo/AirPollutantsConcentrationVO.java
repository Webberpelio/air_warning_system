package com.air_research.airwarningsystem.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author zwell
 */
@Data
@AllArgsConstructor
@ApiModel("各空气污染物浓度和对应的空气质量等级")
public class AirPollutantsConcentrationVO {

    @ApiModelProperty("日期")
    private LocalDate predDate;

    @ApiModelProperty("PM2.5浓度")
    private Double pm25;

    @ApiModelProperty("PM10浓度")
    private Double pm10;

    @ApiModelProperty("SO2浓度")
    private Double so2;

    @ApiModelProperty("CO浓度")
    private Double co;

    @ApiModelProperty("NO2浓度")
    private Double no2;

    @ApiModelProperty("O3浓度")
    private Double o3;

    @ApiModelProperty("空气质量等级")
    private String aqLevel;
}
