package net.wiam.backend.dtos;

import lombok.Data;
import net.wiam.backend.enums.ContratAssuranceStatus;
import net.wiam.backend.enums.NiveauCouverture;

import java.util.Date;

@Data

public class HealthAssuranceContractDTO extends ContratAssuranceDTO {
    private String id;
    private Date date_souscription;
    private Date date_validation;
    private ContratAssuranceStatus status;
    private Double durée;
    private Double taux_couverture;
    private NiveauCouverture niveauCouverture;
    private int nbrePersonnes;
    private ClientDTO clientDTO;
}

