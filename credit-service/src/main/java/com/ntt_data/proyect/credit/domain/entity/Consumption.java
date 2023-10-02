package com.ntt_data.proyect.credit.domain.entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date consumptionDate;
    private Double amout;
    private int installments;
    @ManyToOne(fetch = FetchType.LAZY)
    private Credit credit;

    @OneToMany(mappedBy = "consumption", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Set<PaymentSchedule> paymentSchedules = new HashSet<>();

}
