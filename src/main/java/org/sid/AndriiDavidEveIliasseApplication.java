package org.sid;

import org.sid.dao.ChasseurRepository;
import org.sid.dao.PiloteRepository;
import org.sid.dao.RebelleRepository;
import org.sid.entities.Chasseur;
import org.sid.entities.Mission;
import org.sid.entities.Pilote;
import org.sid.entities.Rebelle;
import org.sid.enums.EtatChasseur;
import org.sid.enums.Race;
import org.sid.enums.TypeChasseur;
import org.sid.services.MissionService;
import org.sid.services.PiloteService;
import org.sid.services.RebelleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AndriiDavidEveIliasseApplication {
    private final PiloteRepository piloteRepository;

    public AndriiDavidEveIliasseApplication(PiloteRepository piloteRepository) {
        this.piloteRepository = piloteRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(AndriiDavidEveIliasseApplication.class, args);
    }


    @Bean
    CommandLineRunner start(RebelleService rebelleService, ChasseurRepository chasseurRepository, MissionService missionService, PiloteService piloteService) {
        return args -> {

            missionService.saveMission(new Mission("maMission"));
            missionService.endMission(1L);
			rebelleService.saveRebelle(new Rebelle("test", "test", Race.HUMAIN, 25));
            piloteService.savePilote(new Pilote("test", "test", Race.HUMAIN,28));

            Pilote pilote1 = new Pilote("Skywalker","Luke", Race.HUMAIN, 23);

            Chasseur chas1 = new Chasseur("Luke's Fighter", TypeChasseur.XWING, EtatChasseur.OPERATIONNEL);
            Chasseur chas2 = new Chasseur("Red Five", TypeChasseur.XWING, EtatChasseur.OPERATIONNEL);
            Chasseur chas3 = new Chasseur("Gold Squadron", TypeChasseur.YWING, EtatChasseur.DETRUIT);
            Chasseur chas4 = new Chasseur("T-70", TypeChasseur.XWING, EtatChasseur.MAINTENANCE);

            chasseurRepository.saveAll(List.of(chas1, chas2, chas3, chas4));
            piloteService.savePilote(pilote1);
//            System.out.println(pilote1.getGrade());
//            pilote1.setHeureDeVol(500);
//            pilote1.setNbMission(2);
//            System.out.println(pilote1.getGrade());
//            pilote1.setHeureDeVol(1200);
//            pilote1.setNbMission(2);
//            System.out.println(pilote1.getGrade());
//            pilote1.setHeureDeVol(1400);
//            pilote1.setNbMission(3);
//            System.out.println(pilote1.getGrade());
//            pilote1.setHeureDeVol(3500);
//            pilote1.setNbMission(11);
//            System.out.println(pilote1.getGrade());
            System.out.println(pilote1.getChasseur());
            pilote1.setChasseur(chas1);
            System.out.println(pilote1.getChasseur());
            pilote1.setChasseur(chas2);
            System.out.println(pilote1.getChasseur());
            pilote1.setChasseur();
            System.out.println(pilote1.getChasseur());
            System.out.println("Bonjour");
        };
    }
}
