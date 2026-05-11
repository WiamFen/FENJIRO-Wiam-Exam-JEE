package net.wiam.backend.reposiories;

import net.wiam.backend.entities.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement,Long> {
}
