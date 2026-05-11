package net.wiam.backend.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Auto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoAssuranceContract extends ContratAssurance {
    private String registrationNumber;
    private String vehicleBrand;
    private String vehicleModel;

}
