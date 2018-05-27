package com.adidashackaton.achillesApp.pojos;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User {

    @Id
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private String gender;

    @Getter
    @Setter
    private String name;
}
