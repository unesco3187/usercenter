package com.xiao6.usercenter.form;

import lombok.Data;

@Data
public class AddUserForm extends BaseForm {

    private String name;
    private String age;
    private String mobile;
    private String condition;
}
