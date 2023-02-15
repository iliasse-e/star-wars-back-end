package org.sid;

import org.sid.dao.ChasseurRepository;
import org.sid.dao.PiloteRepository;
import org.sid.entities.Chasseur;
import org.sid.entities.Pilote;
import org.sid.enums.EtatChasseur;
import org.sid.enums.Race;
import org.sid.enums.Sante;
import org.sid.enums.TypeChasseur;
import org.sid.services.MissionService;
import org.sid.services.PiloteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AndriiDavidEveIliasseApplication {
    private final PiloteRepository piloteRepository;

    public AndriiDavidEveIliasseApplication(PiloteRepository piloteRepository) {
        this.piloteRepository = piloteRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(AndriiDavidEveIliasseApplication.class, args);
    }

    @Configuration
    @EnableWebMvc
    public class WebConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
        }
    }
    @Bean
    CommandLineRunner start(ChasseurRepository chasseurRepository, MissionService missionService, PiloteService piloteService) {
        return args -> {

/*
            chasseurRepository.save(new Chasseur("Luke's Fighter", TypeChasseur.XWING, EtatChasseur.OPERATIONNEL));
            chasseurRepository.save(new Chasseur("Red Five", TypeChasseur.XWING, EtatChasseur.OPERATIONNEL));
            chasseurRepository.save(new Chasseur("Gold Squadron", TypeChasseur.YWING, EtatChasseur.OPERATIONNEL));
            chasseurRepository.save(new Chasseur("T-70", TypeChasseur.XWING, EtatChasseur.MAINTENANCE));

            piloteService.createPilote(new Pilote(null, "Jean", Race.HUMAIN, 34));
            //piloteService.createPilote(new Pilote(null, "Brrrktr", false, Race.KELDOR, 245, 200, 8, Sante.FORME, null, null));
*/

            System.out.println("Bonjour");

        };
    }
}
