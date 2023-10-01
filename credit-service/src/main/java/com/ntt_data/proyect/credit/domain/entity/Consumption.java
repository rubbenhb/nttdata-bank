package com.ntt_data.proyect.credit.domain.entity;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "consumptions")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Consumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consumption_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date consumptionDate;
    private Double amout;
    private int installments;
    @OneToOne
    @JoinColumn(name = "id")
    private Credit creditId;
}
