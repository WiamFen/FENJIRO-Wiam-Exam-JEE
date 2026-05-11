package net.wiam.backend.services;

import jakarta.transaction.Transactional;
import net.wiam.backend.entities.Client;
import net.wiam.backend.entities.ContratAssurance;
import net.wiam.backend.reposiories.ClientRepository;
import net.wiam.backend.reposiories.ContratAssuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class AssuranceServiceImpl implements AssuranceService {

    private final ClientRepository clientRepository;
    private final ContratAssuranceRepository contratRepository;

    public AssuranceServiceImpl(ClientRepository clientRepository,
                                ContratAssuranceRepository contratRepository) {
        this.clientRepository = clientRepository;
        this.contratRepository = contratRepository;
    }

    // ================= CLIENT =================

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // ================= CONTRAT =================

    @Override
    public ContratAssurance saveContract(ContratAssurance contract) {

        // vérifier que le client existe
        if (contract.getClient() == null || contract.getClient().getId() == null) {
            throw new RuntimeException("Client invalide pour le contrat");
        }

        Client client = clientRepository.findById(contract.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        contract.setClient(client);

        return contratRepository.save(contract);
    }

    @Override
    public List<ContratAssurance> getContractsByClient(Long clientId) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        return client.getContratAssurances();
    }
}