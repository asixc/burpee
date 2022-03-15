package com.burpee.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Burpee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "burpee_type")
    private String typeBurpee;

    private int amount;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "modify_date")
    @UpdateTimestamp
    private LocalDateTime modifyDate;

    public Burpee() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeBurpee() {
        return typeBurpee;
    }

    public void setTypeBurpee(String typeBurpee) {
        this.typeBurpee = typeBurpee;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        this.modifyDate = modifyDate;
    }
}
