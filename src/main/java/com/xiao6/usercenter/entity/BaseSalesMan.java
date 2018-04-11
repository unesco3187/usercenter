package com.xiao6.usercenter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Date;

@Table(name = "base_sales_man")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    /**
     * @return sales_id
     */
    public Long getSalesId() {
        return salesId;
    }

    /**
     * @param salesId
     */
    public void setSalesId(Long salesId) {
        this.salesId = salesId;
    }

    /**
     * @return sales_key
     */
    public String getSalesKey() {
        return salesKey;
    }

    /**
     * @param salesKey
     */
    public void setSalesKey(String salesKey) {
        this.salesKey = salesKey;
    }

    /**
     * @return sales_name
     */
    public String getSalesName() {
        return salesName;
    }

    /**
     * @param salesName
     */
    public void setSalesName(String salesName) {
        this.salesName = salesName;
    }

    /**
     * @return sales_tel
     */
    public String getSalesTel() {
        return salesTel;
    }

    /**
     * @param salesTel
     */
    public void setSalesTel(String salesTel) {
        this.salesTel = salesTel;
    }

    /**
     * @return sup_company
     */
    public String getSupCompany() {
        return supCompany;
    }

    /**
     * @param supCompany
     */
    public void setSupCompany(String supCompany) {
        this.supCompany = supCompany;
    }

    /**
     * @return sup_offices
     */
    public String getSupOffices() {
        return supOffices;
    }

    /**
     * @param supOffices
     */
    public void setSupOffices(String supOffices) {
        this.supOffices = supOffices;
    }

    /**
     * 获取0:有效,1:无效,2:删除
     *
     * @return sales_status - 0:有效,1:无效,2:删除
     */
    public String getSalesStatus() {
        return salesStatus;
    }

    /**
     * 设置0:有效,1:无效,2:删除
     *
     * @param salesStatus 0:有效,1:无效,2:删除
     */
    public void setSalesStatus(String salesStatus) {
        this.salesStatus = salesStatus;
    }

    /**
     * @return add_time
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * @param addTime
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return sup_large_area
     */
    public String getSupLargeArea() {
        return supLargeArea;
    }

    /**
     * @param supLargeArea
     */
    public void setSupLargeArea(String supLargeArea) {
        this.supLargeArea = supLargeArea;
    }

    /**
     * @return is_show
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * @param isShow
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    /**
     * 获取备注4
     *
     * @return remarks4 - 备注4
     */
    public String getRemarks4() {
        return remarks4;
    }

    /**
     * 设置备注4
     *
     * @param remarks4 备注4
     */
    public void setRemarks4(String remarks4) {
        this.remarks4 = remarks4;
    }

    /**
     * 获取备注3
     *
     * @return remarks3 - 备注3
     */
    public String getRemarks3() {
        return remarks3;
    }

    /**
     * 设置备注3
     *
     * @param remarks3 备注3
     */
    public void setRemarks3(String remarks3) {
        this.remarks3 = remarks3;
    }

    /**
     * 获取备注2
     *
     * @return remarks2 - 备注2
     */
    public String getRemarks2() {
        return remarks2;
    }

    /**
     * 设置备注2
     *
     * @param remarks2 备注2
     */
    public void setRemarks2(String remarks2) {
        this.remarks2 = remarks2;
    }

    /**
     * 获取备注1
     *
     * @return remarks1 - 备注1
     */
    public String getRemarks1() {
        return remarks1;
    }

    /**
     * 设置备注1
     *
     * @param remarks1 备注1
     */
    public void setRemarks1(String remarks1) {
        this.remarks1 = remarks1;
    }

    /**
     * 获取业务员编号
     *
     * @return sales_num - 业务员编号
     */
    public String getSalesNum() {
        return salesNum;
    }

    /**
     * 设置业务员编号
     *
     * @param salesNum 业务员编号
     */
    public void setSalesNum(String salesNum) {
        this.salesNum = salesNum;
    }

    /**
     * 获取业务员类型（1：招商人员 2运营人员 3两者皆是）
     *
     * @return sales_type - 业务员类型（1：招商人员 2运营人员 3两者皆是）
     */
    public String getSalesType() {
        return salesType;
    }

    /**
     * 设置业务员类型（1：招商人员 2运营人员 3两者皆是）
     *
     * @param salesType 业务员类型（1：招商人员 2运营人员 3两者皆是）
     */
    public void setSalesType(String salesType) {
        this.salesType = salesType;
    }
}