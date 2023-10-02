package com.ntt_data.proyect.credit.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "payment_schedules")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class PaymentSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "num_quota")
    private int numQuota;
    @Column(name = "fee_amount")
    private Double feeAmount;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation")
    private Date dateCreation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;
    private String state;
    private Long movement;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Consumption consumption;
}
