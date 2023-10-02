package com.ntt_data.proyect.account.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "signers")
public class Signer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "ctas")
    private Long ctas;
    @Column(name = "relation")
    private Long relation;
    @Column(name = "sign")
    private Long sign;
}
