package com.ntt_data.proyect.account.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "ctas")
public class Cta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cta;
    @Column(name = "id_holders")
    private Long idHolders;
    @Column(name = "date_creation")
    private Date dateCreation;
    @Column(name = "date_close")
    private Boolean state;
}
