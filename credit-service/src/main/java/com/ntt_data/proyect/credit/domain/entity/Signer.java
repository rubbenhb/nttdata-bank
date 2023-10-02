package com.ntt_data.proyect.credit.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "signers")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Signer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String relation;
    private int product;//1=ahorro 2//credito
    @Column(name = "type_product") //ahorrolibre, cuenta corriente, plazo fijo, credito personal, empresarial, tarjeta
    private String typeProduct;//credit/ahorro
    private String state;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "customer")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "cta")
    private Ctas cta;
}
