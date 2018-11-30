package com.auto.bean;

import com.auto.util.Column;
import com.auto.util.Table;

@Table("user")
public class User {

    @Column("name")
    private String name;

    @Column("age")
    private Integer age;

    @Column("email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
