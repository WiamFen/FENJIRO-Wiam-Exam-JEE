package net.wiam.backend.dtos;

import jakarta.persistence.*;
import lombok.Data;
import net.wiam.backend.enums.PaiementType;

import java.util.Date;

@Data
public class PaiementDTO {
    private Long id;
    private Date paiementDate;
    private double montant;
    private PaiementType type;
}
