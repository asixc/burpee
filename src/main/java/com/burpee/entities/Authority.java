package com.burpee.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="authorities")
public class Authority implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // owner
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    public Authority() {
    }

    public Authority(Long id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
