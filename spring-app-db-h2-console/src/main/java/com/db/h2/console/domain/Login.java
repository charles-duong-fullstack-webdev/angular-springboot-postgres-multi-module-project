package com.db.h2.console.domain;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Login extends Base {

    private String userid;
    private String password;

    public Login(String createdBy, String modifiedBy, LocalDate createdDate, LocalDate modifiedDate, String userid, String password) {
        super(createdBy, modifiedBy, createdDate, modifiedDate);
        this.userid = userid;
        this.password = password;
    }

    public Login() {
    }

    public Login(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


}
