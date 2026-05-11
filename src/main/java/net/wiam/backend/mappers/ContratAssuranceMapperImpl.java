package net.wiam.backend.mappers;

import net.wiam.backend.dtos.*;
import net.wiam.backend.entities.*;
import org.springframework.beans.BeanUtils;

public class ContratAssuranceMapperImpl {
    public ClientDTO fromClient(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }
    public Client fromClientDTO(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }
    public HomeAssuranceContractDTO fromHome(HomeAssuranceContract contract) {
        HomeAssuranceContractDTO dto = new HomeAssuranceContractDTO();

        BeanUtils.copyProperties(contract, dto);

        dto.setClientDTO(fromClient(contract.getClient()));

        dto.setType(contract.getClass().getSimpleName());

        return dto;
    }

    public HomeAssuranceContract fromHomeDTO(HomeAssuranceContractDTO dto) {
        HomeAssuranceContract contract = new HomeAssuranceContract();

        BeanUtils.copyProperties(dto, contract);

        contract.setClient(fromClientDTO(dto.getClientDTO()));

        return contract;
    }


    public AutoAssuranceContractDTO fromAuto(AutoAssuranceContract contract) {
        AutoAssuranceContractDTO dto = new AutoAssuranceContractDTO();

        BeanUtils.copyProperties(contract, dto);

        dto.setClientDTO(fromClient(contract.getClient()));

        dto.setType(contract.getClass().getSimpleName());

        return dto;
    }

    public AutoAssuranceContract fromAutoDTO(AutoAssuranceContractDTO dto) {
        AutoAssuranceContract contract = new AutoAssuranceContract();

        BeanUtils.copyProperties(dto, contract);

        contract.setClient(fromClientDTO(dto.getClientDTO()));

        return contract;
    }


    public HealthAssuranceContractDTO fromHealth(HealthAssuranceContract contract) {
        HealthAssuranceContractDTO dto = new HealthAssuranceContractDTO();

        BeanUtils.copyProperties(contract, dto);

        dto.setClientDTO(fromClient(contract.getClient()));

        dto.setType(contract.getClass().getSimpleName());

        return dto;
    }

    public HealthAssuranceContract fromHealthDTO(HealthAssuranceContractDTO dto) {
        HealthAssuranceContract contract = new HealthAssuranceContract();

        BeanUtils.copyProperties(dto, contract);

        contract.setClient(fromClientDTO(dto.getClientDTO()));

        return contract;
    }


    public PaiementDTO fromPaiement(Paiement paiement) {
        PaiementDTO dto = new PaiementDTO();

        BeanUtils.copyProperties(paiement, dto);

        return dto;
    }

    public Paiement fromPaiementDTO(PaiementDTO dto) {
        Paiement paiement = new Paiement();

        BeanUtils.copyProperties(dto, paiement);

        return paiement;
    }
}
