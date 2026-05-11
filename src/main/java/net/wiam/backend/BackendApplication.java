package net.wiam.backend;

import net.wiam.backend.dtos.ClientDTO;
import net.wiam.backend.entities.*;
import net.wiam.backend.reposiories.ClientRepository;
import net.wiam.backend.reposiories.ContratAssuranceRepository;
import net.wiam.backend.reposiories.PaiementRepository;
import net.wiam.backend.services.AssuranceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import net.wiam.backend.enums.ContratAssuranceStatus;
import net.wiam.backend.enums.LogementType;
import net.wiam.backend.enums.PaiementType;
import net.wiam.backend.enums.NiveauCouverture;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AssuranceService assuranceService) {
        return args -> {

            // ================= CLIENTS =================

            Client c1 = new Client();
            c1.setName("Kamal");
            c1.setEmail("kamal@gmail.com");
            assuranceService.saveClient(c1);

            Client c2 = new Client();
            c2.setName("Imane");
            c2.setEmail("imane@gmail.com");
            assuranceService.saveClient(c2);

            Client c3 = new Client();
            c3.setName("Jamal");
            c3.setEmail("jamal@gmail.com");
            assuranceService.saveClient(c3);

            System.out.println("====== CLIENTS ======");
            assuranceService.getAllClients().forEach(c ->
                    System.out.println(c.getId() + " - " + c.getName())
            );

            // ================= CLIENT DE TEST =================

            Client client = assuranceService.getAllClients().get(0);

            // ================= AUTO CONTRACT =================

            AutoAssuranceContract auto = new AutoAssuranceContract();
            auto.setId(UUID.randomUUID().toString());
            auto.setDate_souscription(new Date());
            auto.setDate_validation(new Date());
            auto.setStatus(ContratAssuranceStatus.EnCours);
            auto.setDurée(12.0);
            auto.setTaux_couverture(80.0);
            auto.setClient(client);
            auto.setRegistrationNumber("123-A-45");
            auto.setVehicleBrand("BMW");
            auto.setVehicleModel("X6");

            assuranceService.saveContract(auto);

            // ================= HOME CONTRACT =================

            HomeAssuranceContract home = new HomeAssuranceContract();
            home.setId(UUID.randomUUID().toString());
            home.setDate_souscription(new Date());
            home.setDate_validation(new Date());
            home.setStatus(ContratAssuranceStatus.Validé);
            home.setDurée(24.0);
            home.setTaux_couverture(90.0);
            home.setClient(client);
            home.setLogementType(LogementType.Appartement);
            home.setAddresse("Casablanca");
            home.setSuperficie(120);

            assuranceService.saveContract(home);

            // ================= HEALTH CONTRACT =================

            HealthAssuranceContract health = new HealthAssuranceContract();
            health.setId(UUID.randomUUID().toString());
            health.setDate_souscription(new Date());
            health.setDate_validation(new Date());
            health.setStatus(ContratAssuranceStatus.EnCours);
            health.setDurée(6.0);
            health.setTaux_couverture(70.0);
            health.setClient(client);
            health.setNiveauCouverture(NiveauCouverture.PREMIUM);
            health.setNbrePersonnes(4);

            assuranceService.saveContract(health);

            // ================= AFFICHAGE CONTRATS =================

            System.out.println("====== CONTRATS ======");

            assuranceService.getContractsByClient(client.getId())
                    .forEach(c ->
                            System.out.println(
                                    c.getId() + " - " + c.getStatus()
                            )
                    );

            System.out.println("====== FIN INITIALISATION ======");
        };
    }

//    @Bean
//    CommandLineRunner commandLineRunner(AssuranceService assuranceService) {
//        return args -> {
//
//            // ================= CLIENTS =================
//
//            Stream.of("Kamal", "Imane", "Jamal").forEach(name -> {
//
//                Client client = new Client();
//                client.setName(name);
//                client.setEmail(name.toLowerCase() + "@gmail.com");
//
//                assuranceService.saveClient(client);
//            });
//
//            // ================= TEST LECTURE CLIENTS =================
//
//            System.out.println("====== CLIENTS ======");
//
//            assuranceService.getAllClients().forEach(c ->
//                    System.out.println(c.getName() + " - " + c.getEmail())
//            );
//
//            // ================= CONTRAT TEST SIMPLE =================
//
//            Client client = assuranceService.getAllClients().get(0);
//
//            AutoAssuranceContract auto = new AutoAssuranceContract();
//            auto.setId(UUID.randomUUID().toString());
//            auto.setDate_souscription(new Date());
//            auto.setDate_validation(new Date());
//            auto.setStatus(ContratAssuranceStatus.EnCours);
//            auto.setDurée(12.0);
//            auto.setTaux_couverture(80.0);
//            auto.setClient(client);
//
//            auto.setRegistrationNumber("123-A-45");
//            auto.setVehicleBrand("BMW");
//            auto.setVehicleModel("X6");
//
//            assuranceService.saveContract(auto);
//
//            // ================= HOME CONTRACT =================
//
//            HomeAssuranceContract home = new HomeAssuranceContract();
//            home.setId(UUID.randomUUID().toString());
//            home.setDate_souscription(new Date());
//            home.setDate_validation(new Date());
//            home.setStatus(ContratAssuranceStatus.Validé);
//            home.setDurée(24.0);
//            home.setTaux_couverture(90.0);
//            home.setClient(client);
//
//            home.setLogementType(LogementType.Appartement);
//            home.setAddresse("Casablanca");
//            home.setSuperficie(120);
//
//            assuranceService.saveContract(home);
//
//            // ================= HEALTH CONTRACT =================
//
//            HealthAssuranceContract health = new HealthAssuranceContract();
//            health.setId(UUID.randomUUID().toString());
//            health.setDate_souscription(new Date());
//            health.setDate_validation(new Date());
//            health.setStatus(ContratAssuranceStatus.EnCours);
//            health.setDurée(6.0);
//            health.setTaux_couverture(70.0);
//            health.setClient(client);
//
//            health.setNiveauCouverture(NiveauCouverture.PREMIUM);
//            health.setNbrePersonnes(4);
//
//            assuranceService.saveContract(health);
//
//            // ================= AFFICHAGE CONTRATS =================
//
//            System.out.println("====== CONTRATS ======");
//
//            assuranceService.getContractsByClient(client.getId())
//                    .forEach(contract ->
//                            System.out.println(
//                                    contract.getId() + " - " +
//                                            contract.getStatus()
//                            )
//                    );
//        };
//    }
    //@Bean
//    CommandLineRunner commandLineRunner(AssuranceService assuranceService) {
//        return args -> {
//
//            Stream.of("Kamal", "Imane", "Jamal").forEach(name -> {
//
//                ClientDTO clientDTO = new ClientDTO();
//                clientDTO.setName(name);
//                clientDTO.setEmail(name.toLowerCase() + "@gmail.com");
//
//                assuranceService.saveClient(
//                        new Client(
//                                null,
//                                clientDTO.getName(),
//                                clientDTO.getEmail(),
//                                null
//                        )
//                );
//            });
//
//            assuranceService.getAllClients().forEach(c ->
//                    System.out.println(c.getName())
//            );
//        };
//    }

    //@Bean
    CommandLineRunner start(
            ClientRepository clientRepository,
            ContratAssuranceRepository contratRepository,
            PaiementRepository paiementRepository
    ) {
        return args -> {

            // ================= CLIENTS =================

            Client c1 = new Client();
            c1.setName("Wiam");
            c1.setEmail("wiam@gmail.com");

            Client c2 = new Client();
            c2.setName("Ali");
            c2.setEmail("ali@gmail.com");

            clientRepository.save(c1);
            clientRepository.save(c2);


            AutoAssuranceContract auto =
                    new AutoAssuranceContract();

            auto.setId(UUID.randomUUID().toString());

            auto.setDate_souscription(new Date());

            auto.setStatus(ContratAssuranceStatus.EnCours);

            auto.setDurée(12.0);

            auto.setTaux_couverture(80.0);

            auto.setClient(c1);

            auto.setRegistrationNumber("123-A-45");

            auto.setVehicleBrand("BMW");

            auto.setVehicleModel("X6");

            contratRepository.save(auto);

            // ================= HOME CONTRACT =================

            HomeAssuranceContract home = new HomeAssuranceContract();

            home.setId(UUID.randomUUID().toString());

            home.setDate_souscription(new Date());

            home.setStatus(ContratAssuranceStatus.Validé);

            home.setDurée(24.0);

            home.setTaux_couverture(90.0);

            home.setClient(c2);

            home.setLogementType(LogementType.Appartement);

            home.setAddresse("Casablanca");

            home.setSuperficie(120);

            contratRepository.save(home);

            // ================= HEALTH CONTRACT =================

            HealthAssuranceContract health = new HealthAssuranceContract();

            health.setId(UUID.randomUUID().toString());

            health.setDate_souscription(new Date());

            health.setStatus(ContratAssuranceStatus.EnCours);

            health.setDurée(6.0);

            health.setTaux_couverture(70.0);

            health.setClient(c1);

            health.setNiveauCouverture(
                    NiveauCouverture.PREMIUM
            );

            health.setNbrePersonnes(4);

            contratRepository.save(health);

            // ================= PAIEMENTS =================

            Paiement p1 = new Paiement();

            p1.setPaiementDate(new Date());

            p1.setMontant(1500);

            p1.setType(PaiementType.MENSUEL);

            p1.setContratAssurance(auto);

            paiementRepository.save(p1);

            Paiement p2 = new Paiement();

            p2.setPaiementDate(new Date());

            p2.setMontant(3000);

            p2.setType(PaiementType.ANNUEL);

            p2.setContratAssurance(home);

            paiementRepository.save(p2);

            // ================= AFFICHAGE =================

            System.out.println("====== CLIENTS ======");

            clientRepository.findAll().forEach(client -> {
                System.out.println(client.getName());
            });

            System.out.println("====== CONTRATS ======");

            contratRepository.findAll().forEach(contract -> {
                System.out.println(
                        contract.getId() + " " +
                                contract.getStatus()
                );
            });

            System.out.println("====== PAIEMENTS ======");

            paiementRepository.findAll().forEach(payment -> {
                System.out.println(
                        payment.getMontant()
                );
            });

        };
    }
}
