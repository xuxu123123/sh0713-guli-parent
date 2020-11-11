package com.atguigu.guli.service.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class BaseEntity {
    private String id;
    @TableField(fill = FieldFill.INSERT )
   @JsonFormat(pattern = "yyyy-MM-dd")
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date gmtModified;

}
