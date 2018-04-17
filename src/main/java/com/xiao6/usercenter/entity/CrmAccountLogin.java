package com.xiao6.usercenter.entity;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

@Table(name = "crm_account_login")
@Data
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
}