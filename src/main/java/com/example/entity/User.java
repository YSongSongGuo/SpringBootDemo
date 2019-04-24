package com.example.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @author Squirrel
 * @date 2019/4/24 14:54
 * @desc
 */
@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    @Column(name = "id",columnDefinition = "varchar(32) COMMENT '用户主键ID' ")
    private String id;

    @Column(name = "userName",columnDefinition = "varchar(32) COMMENT '姓名' ")
    private String userName;

    @Column(name = "sex",columnDefinition = "varchar(32) COMMENT '性别' ")
    private String sex;

    @Column(name = "age",columnDefinition = "int(11) COMMENT '年龄' ")
    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @Column(name = "creatDate",columnDefinition = "datetime COMMENT '创建时间' ")
    private Date creatDate;

    @Column(name = "delStatus",columnDefinition = "bit(1) COMMENT '删除标记（0：正常，1：删除）' ")
    private boolean delStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public boolean isDelStatus() {
        return delStatus;
    }

    public void setDelStatus(boolean delStatus) {
        this.delStatus = delStatus;
    }
}
