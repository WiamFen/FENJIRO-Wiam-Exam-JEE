package net.wiam.backend.dtos;

import lombok.Data;
import net.wiam.backend.enums.ContratAssuranceStatus;

import java.util.Date;


@Data
public class AutoAssuranceContractDTO extends ContratAssuranceDTO {
    private String id;
    private Date date_souscription;
    private Date date_validation;
    private ContratAssuranceStatus status;
    private Double durée;
    private Double taux_couverture;
    private String registrationNumber;
    private String vehicleBrand;
    private String vehicleModel;
    private ClientDTO clientDTO;
}
