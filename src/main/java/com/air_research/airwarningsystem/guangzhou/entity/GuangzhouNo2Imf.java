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
@TableName("tb_guangzhou_no2_imf")
@ApiModel(value="GuangzhouNo2Imf对象", description="")
public class GuangzhouNo2Imf implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate predDate;

    private Integer imf1;

    private Integer imf2;


}
