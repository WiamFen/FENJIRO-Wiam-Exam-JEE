package net.wiam.backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.wiam.backend.enums.NiveauCouverture;

@Entity
@DiscriminatorValue("Santé")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthAssuranceContract extends ContratAssurance {
    @Enumerated(EnumType.STRING)
    private NiveauCouverture niveauCouverture;
    private int nbrePersonnes;
}

