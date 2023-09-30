package com.ntt_data.proyect.transaction.domain.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

@Entity
@Table(name ="movements")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mov_type_id;
    @Column(name = "consu_type")
    private String consu_type;
    @Column(name = "cta")
    private String cta;
    @Column(name = "amount")
    private String amount;
    @Column(name = "num_quota")
    private String num_quota;
    @Column(name = "date")
    private Date date;
}
