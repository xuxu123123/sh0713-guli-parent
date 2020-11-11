package com.atguigu.guli.service.edu.entity.from;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
@ApiModel("讲师查询对象")
public class SearchForm {
    @ApiModelProperty(value = "讲师姓名")
    private String name;


    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;


    @ApiModelProperty(value = "开始时间")
    private String joinDateBegin;
    @ApiModelProperty(value = "结束时间")
    private String joinDateEnd;
}
