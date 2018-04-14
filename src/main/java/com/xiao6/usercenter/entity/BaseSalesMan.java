package com.xiao6.usercenter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "base_sales_man")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class BaseSalesMan {
    @Id
    @Column(name = "sales_id")
    @JsonIgnore
    private Long salesId;

    @Column(name = "sales_key")
    private String salesKey;

    @Column(name = "sales_name")
    private String salesName;

    @Column(name = "sales_tel")
    private String salesTel;

    @Column(name = "sup_company")
    private String supCompany;

    @Column(name = "sup_offices")
    private String supOffices;

    /**
     * 0:有效,1:无效,2:删除
     */
    @Column(name = "sales_status")
    private String salesStatus;

    @Column(name = "add_time")
    private Date addTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "sup_large_area")
    private String supLargeArea;

    @Column(name = "is_show")
    private String isShow;

    /**
     * 备注4
     */
    private String remarks4;

    /**
     * 备注3
     */
    private String remarks3;

    /**
     * 备注2
     */
    private String remarks2;

    /**
     * 备注1
     */
    private String remarks1;

    /**
     * 业务员编号
     */
    @Column(name = "sales_num")
    private String salesNum;

    /**
     * 业务员类型（1：招商人员 2运营人员 3两者皆是）
     */
    @Column(name = "sales_type")
    private String salesType;
}