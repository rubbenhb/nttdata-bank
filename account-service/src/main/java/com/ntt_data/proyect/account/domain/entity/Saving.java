package com.ntt_data.proyect.account.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "savings")
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cta")
    private Long cta;
    @Column(name = "type_saving")
    private Boolean typeSaving;
    @Column(name = "balance")
    private Float balance;
    @Column(name = "commission")
    private Float commission;
    @Column(name = "interest_rate")
    private Float interestRate;
    @Column(name = "state")
    private Boolean state;
    @Column(name = "num_mov")
    private Integer numMov;
    @Column(name = "date_creation")
    private Date dateCreation;
    @Column(name = "date_close")
    private Date dateClose;
    @Column(name = "typo_coin")
    private String typoCoin;
}
