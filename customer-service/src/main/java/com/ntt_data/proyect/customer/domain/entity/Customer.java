package com.ntt_data.proyect.customer.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "document_type")
    private Integer documentType;

    @Column(name = "document_number")
    private Long documentNumber;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "state")
    private Integer state;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;
}