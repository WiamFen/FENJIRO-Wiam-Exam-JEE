package net.wiam.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.wiam.backend.enums.PaiementType;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date paiementDate;
    private double montant;
    @Enumerated(EnumType.STRING)
    private PaiementType type;
    @ManyToOne
    private ContratAssurance contratAssurance;
}
