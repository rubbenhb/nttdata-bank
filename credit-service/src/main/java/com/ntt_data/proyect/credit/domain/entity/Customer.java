package com.ntt_data.proyect.credit.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "doc_type")
    private int docType;
    @Column(name = "nro_doc")
    private Long nroDoc;
    @Column(name = "client_type")
    private int clientType;//1= personal, 2= empresarial
    private String direction;
    private String gender;
    private int state;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Signer signer;
}
