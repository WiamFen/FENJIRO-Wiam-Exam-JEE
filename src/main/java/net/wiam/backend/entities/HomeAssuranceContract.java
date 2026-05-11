package net.wiam.backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.wiam.backend.enums.LogementType;

@Entity
@DiscriminatorValue("Home")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeAssuranceContract extends ContratAssurance {
    @Enumerated(EnumType.STRING)
    private LogementType logementType;
    private String addresse;
    private double superficie;
}

