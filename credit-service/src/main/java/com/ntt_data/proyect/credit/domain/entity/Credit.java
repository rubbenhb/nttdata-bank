package com.ntt_data.proyect.credit.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.*;
@Entity
@Table(name = "credits")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Builder
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date deadline;
    @Column(name = "nro_doc")
    private Long nroDoc;
    @Column(name = "num_quotas")
    private int numQuotas;

    @Column(name = "credit_line")
    private Double creditLine;
    @Column(name = "grant_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date grantDate;
    private Double tea;
    @Column(name = "type_coin")
    private String typeCoin;
    @Column(name = "type_credit")
    private String typeCredit;

    @OneToOne(optional = true)
    @JoinColumn(name = "cta")
    private Ctas cta;

    @OneToMany(mappedBy = "credit",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Set<Consumption> consumptions = new HashSet<>();

}
