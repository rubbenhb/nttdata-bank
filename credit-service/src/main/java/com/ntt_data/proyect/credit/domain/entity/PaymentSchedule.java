package com.ntt_data.proyect.credit.domain.entity;

import javax.persistence.*;
import java.util.*;
@Entity
public class PaymentSchedule {
    private Long id;

    private int num_quota;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;
    private String state;
    private Long movement;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dayDelay;
    @OneToOne
    @JoinColumn(name = "id")
    private Consumption consumption;
}
