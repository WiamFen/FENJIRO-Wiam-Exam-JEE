package net.wiam.backend.web;

import net.wiam.backend.entities.ContratAssurance;
import net.wiam.backend.services.AssuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@CrossOrigin("*")
public class ContratRestController {

    private final AssuranceService assuranceService;

    public ContratRestController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    @PostMapping
    public ContratAssurance saveContract(@RequestBody ContratAssurance contract) {
        return assuranceService.saveContract(contract);
    }

    @GetMapping("/client/{clientId}")
    public List<ContratAssurance> getContractsByClient(@PathVariable Long clientId) {
        return assuranceService.getContractsByClient(clientId);
    }
}