package com.action;

import com.dao.RegisterDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 单独的病人注册action
 */
public class UserRegisterAction  extends ActionSupport {

    private String name;
    private String pass;
    private String phone;
    private String email;
    private String age;
    private String sex;


    public String execute() {
        System.out.println("注册信息界面接受到数据");
        RegisterDao rs=new RegisterDao();
            rs.patientRegister("", name, pass, phone, email, sex, age, "","","","");
        return "success";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
