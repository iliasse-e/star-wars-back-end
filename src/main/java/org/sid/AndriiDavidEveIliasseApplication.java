package org.sid;

import java.util.ArrayList;
import java.util.List;

import org.sid.dao.ChasseurRepository;
import org.sid.dao.MissionRepository;
import org.sid.dao.PiloteRepository;
import org.sid.dao.RebelleRepository;
import org.sid.entities.Mission;
import org.sid.entities.Pilote;
import org.sid.entities.Rebelle;
import org.sid.services.MissionService;
import org.sid.services.PiloteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AndriiDavidEveIliasseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndriiDavidEveIliasseApplication.class, args);
		System.out.println("Bonjour");
		
	}
	@Bean
	CommandLineRunner start(RebelleRepository rebelleRepository, ChasseurRepository chasseurRepository, PiloteRepository piloteRepository, MissionService missionService, PiloteService piloteService) {
		return args -> {
			
			missionService.saveMission(new Mission());
			missionService.endMission(1L);
			piloteService.savePilote(new Pilote());
		};
		
	}

}
