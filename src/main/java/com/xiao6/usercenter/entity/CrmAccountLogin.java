package com.xiao6.usercenter.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "crm_account_login")
public class CrmAccountLogin {
    /**
     * 登入KEY
     */
    @Id
    @Column(name = "login_key")
    private String loginKey;

    /**
     * 账户Key
     */
    @Column(name = "account_key")
    private String accountKey;

    /**
     * 登入类型(1:用户名, 2:手机号, 3:微信, 4:QQ)
     */
    @Column(name = "login_type")
    private String loginType;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "pass_word")
    private String passWord;

    /**
     * 应用Key
     */
    @Column(name = "apply_key")
    private String applyKey;

    /**
     * 修改次数
     */
    @Column(name = "mod_num")
    private Integer modNum;

    /**
     * 加密类型
     */
    @Column(name = "encrypt_type")
    private String encryptType;

    /**
     * 状态(0:有效, 1:冻结, 2:解绑)
     */
    private String status;

    /**
     * 显示标记(0:显示, 1:隐藏)
     */
    @Column(name = "show_flag")
    private String showFlag;

    /**
     * 删除标记(1:是, 0:否)
     */
    @Column(name = "delete_flag")
    private String deleteFlag;

    /**
     * 业务员编号
     */
    @Column(name = "sales_num")
    private String salesNum;

    /**
     * 创建人Key
     */
    @Column(name = "add_user_key")
    private String addUserKey;

    /**
     * 新增时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 更新人Key
     */
    @Column(name = "mod_user_key")
    private String modUserKey;

    /**
     * 更新时间
     */
    @Column(name = "mod_time")
    private Date modTime;

    /**
     * 获取登入KEY
     *
     * @return login_key - 登入KEY
     */
    public String getLoginKey() {
        return loginKey;
    }

    /**
     * 设置登入KEY
     *
     * @param loginKey 登入KEY
     */
    public void setLoginKey(String loginKey) {
        this.loginKey = loginKey;
    }

    /**
     * 获取账户Key
     *
     * @return account_key - 账户Key
     */
    public String getAccountKey() {
        return accountKey;
    }

    /**
     * 设置账户Key
     *
     * @param accountKey 账户Key
     */
    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey;
    }

    /**
     * 获取登入类型(1:用户名, 2:手机号, 3:微信, 4:QQ)
     *
     * @return login_type - 登入类型(1:用户名, 2:手机号, 3:微信, 4:QQ)
     */
    public String getLoginType() {
        return loginType;
    }

    /**
     * 设置登入类型(1:用户名, 2:手机号, 3:微信, 4:QQ)
     *
     * @param loginType 登入类型(1:用户名, 2:手机号, 3:微信, 4:QQ)
     */
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码
     *
     * @return pass_word - 密码
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 设置密码
     *
     * @param passWord 密码
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    /**
     * 获取应用Key
     *
     * @return apply_key - 应用Key
     */
    public String getApplyKey() {
        return applyKey;
    }

    /**
     * 设置应用Key
     *
     * @param applyKey 应用Key
     */
    public void setApplyKey(String applyKey) {
        this.applyKey = applyKey;
    }

    /**
     * 获取修改次数
     *
     * @return mod_num - 修改次数
     */
    public Integer getModNum() {
        return modNum;
    }

    /**
     * 设置修改次数
     *
     * @param modNum 修改次数
     */
    public void setModNum(Integer modNum) {
        this.modNum = modNum;
    }

    /**
     * 获取加密类型
     *
     * @return encrypt_type - 加密类型
     */
    public String getEncryptType() {
        return encryptType;
    }

    /**
     * 设置加密类型
     *
     * @param encryptType 加密类型
     */
    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    /**
     * 获取状态(0:有效, 1:冻结, 2:解绑)
     *
     * @return status - 状态(0:有效, 1:冻结, 2:解绑)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态(0:有效, 1:冻结, 2:解绑)
     *
     * @param status 状态(0:有效, 1:冻结, 2:解绑)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取显示标记(0:显示, 1:隐藏)
     *
     * @return show_flag - 显示标记(0:显示, 1:隐藏)
     */
    public String getShowFlag() {
        return showFlag;
    }

    /**
     * 设置显示标记(0:显示, 1:隐藏)
     *
     * @param showFlag 显示标记(0:显示, 1:隐藏)
     */
    public void setShowFlag(String showFlag) {
        this.showFlag = showFlag;
    }

    /**
     * 获取删除标记(1:是, 0:否)
     *
     * @return delete_flag - 删除标记(1:是, 0:否)
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标记(1:是, 0:否)
     *
     * @param deleteFlag 删除标记(1:是, 0:否)
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
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
     * 获取创建人Key
     *
     * @return add_user_key - 创建人Key
     */
    public String getAddUserKey() {
        return addUserKey;
    }

    /**
     * 设置创建人Key
     *
     * @param addUserKey 创建人Key
     */
    public void setAddUserKey(String addUserKey) {
        this.addUserKey = addUserKey;
    }

    /**
     * 获取新增时间
     *
     * @return add_time - 新增时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置新增时间
     *
     * @param addTime 新增时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取更新人Key
     *
     * @return mod_user_key - 更新人Key
     */
    public String getModUserKey() {
        return modUserKey;
    }

    /**
     * 设置更新人Key
     *
     * @param modUserKey 更新人Key
     */
    public void setModUserKey(String modUserKey) {
        this.modUserKey = modUserKey;
    }

    /**
     * 获取更新时间
     *
     * @return mod_time - 更新时间
     */
    public Date getModTime() {
        return modTime;
    }

    /**
     * 设置更新时间
     *
     * @param modTime 更新时间
     */
    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }
}