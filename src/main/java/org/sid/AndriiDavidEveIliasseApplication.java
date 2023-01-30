package org.sid;

import org.sid.dao.PiloteRepository;
import org.sid.dao.RebelleRepository;
import org.sid.entities.Chasseur;
import org.sid.entities.Mission;
import org.sid.enums.EtatChasseur;
import org.sid.enums.TypeChasseur;
import org.sid.services.ChasseurService;
import org.sid.services.MissionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AndriiDavidEveIliasseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndriiDavidEveIliasseApplication.class, args);
		System.out.println("Bonjour");
	}

	@Bean
	CommandLineRunner start(RebelleRepository rebelleRepository, ChasseurService chasseurService,
			PiloteRepository piloteRepository, MissionService missionService) {
		return args -> {
			missionService.saveMission(new Mission());
			missionService.endMission(1L);
			chasseurService.saveChasseur(new Chasseur("Luke's Fighter", TypeChasseur.XWING, EtatChasseur.OPERATIONNEL));
			chasseurService.saveChasseur(new Chasseur("Red Five", TypeChasseur.XWING, EtatChasseur.OPERATIONNEL));
			chasseurService.saveChasseur(new Chasseur("T-70", TypeChasseur.XWING, EtatChasseur.MAINTENANCE));
			chasseurService.saveChasseur(new Chasseur("Gold Squadron", TypeChasseur.YWING, EtatChasseur.DETRUIT));
			chasseurService.listChasseurs();
		};
	}
}
