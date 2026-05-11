package net.wiam.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.wiam.backend.enums.ContratAssuranceStatus;

import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",length = 5)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ContratAssurance {
    @Id
    private String id;
    private Date date_souscription;
    private Date date_validation;
    @Enumerated(EnumType.STRING)
    private ContratAssuranceStatus status;
    private Double durée;
    private Double taux_couverture;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "contratAssurance",fetch = FetchType.LAZY)
    private List<Paiement> paiements;
}
