package com.xiao6.usercenter.entity;

import lombok.Data;
import org.apache.ibatis.annotations.Options;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Data
public class Girl {
    @Id
    //    @GeneratedValue(generator = "Mysql",strategy=GenerationType.IDENTITY)
    private Integer id;

    private Integer age;

    @Column(name = "cup_size")
    private String cupSize;

    @Column(name = "create_time")
    private Date createTime;
}