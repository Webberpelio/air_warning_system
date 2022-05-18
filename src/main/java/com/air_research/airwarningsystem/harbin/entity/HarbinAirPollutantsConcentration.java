package com.air_research.airwarningsystem.harbin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Wilson Zhang
 * @since 2022-05-17
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("tb_harbin_air_pollutants_concentration")
@ApiModel(value="HarbinAirPollutantsConcentration对象", description="")
public class HarbinAirPollutantsConcentration implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate predDate;

    private Double pm25;

    private Double pm10;

    private Double so2;

    private Double co;

    private Double no2;

    private Double o3;

    private String aqLevel;


}
