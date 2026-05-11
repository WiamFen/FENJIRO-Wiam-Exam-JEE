package net.wiam.backend.services;

import net.wiam.backend.entities.Client;
import net.wiam.backend.entities.ContratAssurance;


import java.util.List;

public interface AssuranceService {

    Client saveClient(Client client);
    Client getClient(Long id);
    List<Client> getAllClients();
    ContratAssurance saveContract(ContratAssurance contract);
    List<ContratAssurance> getContractsByClient(Long clientId);

}
