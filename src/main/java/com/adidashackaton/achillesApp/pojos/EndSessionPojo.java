package com.adidashackaton.achillesApp.pojos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

public class EndSessionPojo {

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String foot;

    @Getter
    @Setter
    private double meters;

    @Getter
    @Setter
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Getter
    @Setter
    private double sensor1;

    @Getter
    @Setter
    private double sensor2;

    @Getter
    @Setter
    private double sensor3;

    @Getter
    @Setter
    private double sensor4;

}
