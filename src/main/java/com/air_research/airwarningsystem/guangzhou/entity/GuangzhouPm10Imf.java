package com.air_research.airwarningsystem.guangzhou.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@EqualsAndHashCode(callSuper = false)
@TableName("tb_guangzhou_pm10_imf")
@ApiModel(value="GuangzhouPm10Imf对象", description="")
public class GuangzhouPm10Imf implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate predDate;

    private Double imf1;

    private Double imf2;

    private Double imf3;

    private Double imf4;

    private Double imf5;

    private Double imf6;


}
