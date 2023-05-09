package com.db.h2.console.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

//import org.apache.commons.lang3.builder.ToStringBuilder;
//import org.apache.commons.lang3.builder.ToStringStyle;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.time.LocalDateTime;
//import java.util.Objects;


@MappedSuperclass
//@EntityListeners({EntityListener.class})
public abstract class BaseEntity {

    @CreatedBy
    @NotNull
    @Size(max = 100)
    private String createdBy;
    @LastModifiedBy
    @NotNull
    @Size(max = 100)
    private String modifiedBy;

    @Column(name = "createdDate")
    @NotNull
    @Size(min = 26, max = 30)
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(name = "modifiedDate")
    @NotNull
    @Size(min = 26, max = 30)
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }


}
