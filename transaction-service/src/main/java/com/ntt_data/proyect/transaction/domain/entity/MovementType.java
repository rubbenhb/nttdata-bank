package com.ntt_data.proyect.transaction.domain.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter

@Entity
@Table(name = "movement_type")
public class MovementType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "description")
    private String description;
    @Column(name = "state")
    private String state;
}
