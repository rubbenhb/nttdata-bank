package com.ntt_data.proyect.credit.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "credits")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor @Builder
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Double amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;

    @Column(name = "num_quotas")
    private Double numQuotas;

    @Column(name = "credit_line")
    private Double creditLine;
    @Column(name = "grant_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date grantDate;
    @Column(name = "expery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;
    private Double tcea;
    @Column(name = "type_coin")
    private String typeCoin;
    @Column(name = "type_credit")
    private int typeCredit;
    @OneToOne(optional = true)
    @JoinColumn(name = "cta")
    private Ctas cta;
    @OneToOne
    @JoinColumn(name = "id")
    private Customer customer;
}
