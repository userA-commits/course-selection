package com.graduation.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 王奥
 * @since 2022-03-11
 */
@ApiModel("教室实体")
public class Classroom implements Serializable {

private static final long serialVersionUID=1L;

    @TableId(value = "rid", type = IdType.AUTO)
    @ApiModelProperty(name = "教室ID", dataType = "String")
    private String rid;
    @ApiModelProperty(name = "教室类型", dataType = "Int")
    private Integer type;
    @ApiModelProperty(name = "最大容纳人数", dataType = "Int")
    private Integer maximum;


    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "Classroom{" +
        "rid=" + rid +
        ", type=" + type +
        ", maximum=" + maximum +
        "}";
    }
}
