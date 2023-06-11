package com.springcloud.api;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = false)
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pId", type = IdType.AUTO)
    private Integer pid;

    @TableField("pName")
    private String pname;

    @TableField("pType")
    private String ptype;

    @TableField("pWarehouse")
    private Integer pwarehouse;

    @TableField("pManage")
    private String pmanage;

    @TableField("pCount")
    private Double pcount;

    @TableField("pUnit")
    private String punit;

    @TableField("pTime")
    private java.util.Date ptime;

}
