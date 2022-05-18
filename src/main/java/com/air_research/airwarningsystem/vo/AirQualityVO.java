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
@ApiModel("空气质量等级")
public class AirQualityVO {

    @ApiModelProperty("日期")
    private LocalDate date;

    @ApiModelProperty("空气质量等级")
    private String airQualityLevel;
}
