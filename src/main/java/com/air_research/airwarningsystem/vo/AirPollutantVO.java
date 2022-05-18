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
@ApiModel("空气污染物浓度")
public class AirPollutantVO {

    @ApiModelProperty("日期")
    private LocalDate date;

    @ApiModelProperty("污染物浓度")
    private Double pollutantConcentration;
}
