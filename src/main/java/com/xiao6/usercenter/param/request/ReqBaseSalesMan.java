package com.xiao6.usercenter.param.request;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.io.Serializable;

public class ReqBaseSalesMan implements Serializable {

    @ApiModelProperty("账号")
    private String salesName;

    /**
     * 业务员类型（1：招商人员 2运营人员 3两者皆是）
     */
    @Column(name = "sales_type")
    @ApiModelProperty(value = "业务员类型（1：招商人员 2运营人员 3两者皆是）",required = true)
    private Integer salesType;

    public String getSalesName() {
        return salesName;
    }

    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    public Integer getSalesType() {
        return salesType;
    }

    public void setSalesType(Integer salesType) {
        this.salesType = salesType;
    }
}
