package org.sid;

import java.util.List;

import org.sid.dao.ChasseurRepository;
import org.sid.entities.Chasseur;
import org.sid.enums.EtatChasseur;
import org.sid.enums.TypeChasseur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AndriiDavidEveIliasseApplication {

    public static void main(String[] args) {
	SpringApplication.run(AndriiDavidEveIliasseApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ChasseurRepository chasseurRepository) {
	return args -> {
	    Chasseur chas1 = new Chasseur("Luke's Fighter", TypeChasseur.XWING, EtatChasseur.OPERATIONNEL);
	    Chasseur chas2 = new Chasseur("Red Five", TypeChasseur.XWING, EtatChasseur.OPERATIONNEL);
	    Chasseur chas3 = new Chasseur("Gold Squadron", TypeChasseur.YWING, EtatChasseur.DETRUIT);
	    Chasseur chas4 = new Chasseur("T-70", TypeChasseur.XWING, EtatChasseur.MAINTENANCE);

	    chasseurRepository.saveAll(List.of(chas1, chas2, chas3, chas4));
	};
    }
}
