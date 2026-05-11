package net.wiam.backend.dtos;

import lombok.Data;
import net.wiam.backend.enums.ContratAssuranceStatus;
import net.wiam.backend.enums.LogementType;

import java.util.Date;

@Data

public class HomeAssuranceContractDTO extends ContratAssuranceDTO {
    private String id;
    private Date date_souscription;
    private Date date_validation;
    private ContratAssuranceStatus status;
    private Double durée;
    private Double taux_couverture;
    private LogementType logementType;
    private String addresse;
    private double superficie;
    private ClientDTO clientDTO;
}

