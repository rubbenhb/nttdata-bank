package com.ntt_data.proyect.credit.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "Ctas")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Ctas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cta;
    @Column(name = "type_product")
    private String typeProduct;
    @Column(name = "date_creation")
    private Date dateCreation;
    @Column(name = "date_close")
    private Date dateClose;
    private String state;
    @OneToOne(mappedBy = "cta", cascade = CascadeType.ALL)
    private Signer signer;
}
