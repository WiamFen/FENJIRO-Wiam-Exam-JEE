package net.wiam.backend.web;

import net.wiam.backend.entities.Client;
import net.wiam.backend.services.AssuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin("*")
public class ClientRestController {

    private final AssuranceService assuranceService;

    public ClientRestController(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return assuranceService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id) {
        return assuranceService.getClient(id);
    }

    @PostMapping
    public Client saveClient(@RequestBody Client client) {
        return assuranceService.saveClient(client);
    }
}