package net.wiam.backend.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.wiam.backend.enums.ContratAssuranceStatus;

import java.util.Date;
import java.util.List;

@Data
public abstract class ContratAssuranceDTO {
    private String type;
}
