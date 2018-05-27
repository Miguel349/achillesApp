package com.adidashackaton.achillesApp.pojos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "sesion")
public class Sesion {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private int meters;

    @Getter
    @Setter
    private int calories;

    @Getter
    @Setter
    private double leftSensor1;

    @Getter
    @Setter
    private double leftSensor2;

    @Getter
    @Setter
    private double leftSensor3;

    @Getter
    @Setter
    private double leftSensor4;

    @Getter
    @Setter
    private double rightSensor1;

    @Getter
    @Setter
    private double rightSensor2;

    @Getter
    @Setter
    private double rightSensor3;

    @Getter
    @Setter
    private double rightSensor4;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
}
