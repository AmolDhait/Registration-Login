package com.bridgelabz.registrationlogin.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "role")
@Getter
@Setter
public @Data class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Role(String name) {
        super();
        this.name= name;
    }

    public Role() {
    }

}
