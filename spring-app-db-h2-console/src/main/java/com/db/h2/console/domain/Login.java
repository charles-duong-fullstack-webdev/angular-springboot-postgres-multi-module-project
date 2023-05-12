package com.db.h2.console.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;
import reactor.util.annotation.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Login extends BaseEntity {

    @GenericGenerator(
            name = "LoginSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "login_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LoginSequenceGenerator")
    private Long id;

    private String userid;
    private String password;


    @Column(name = "birthday")
    @NotNull
//    @CreatedDate
//    private LocalDateTime birthday;

//    @Temporal(TemporalType.DATE)
//    @DateTimeFormat(style = "S-")
//    private Date birthday;

    private LocalDate birthday;

    public Login() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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
                "id=" + id +
                ", userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", createdBy='" + getCreatedBy() + '\'' +
                ", createdDate='" + getCreatedDate() + '\'' +
                ", modifiedBy='" + getModifiedBy() + '\'' +
                ", modifiedDate='" + getModifiedDate() + '\'' +
                '}';
    }

}
