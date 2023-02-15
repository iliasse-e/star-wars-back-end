package org.sid.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Mission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	@OneToMany(mappedBy = "missionActuelle", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Pilote> pilotes = new ArrayList<Pilote>();
	private int nbHeureMission = 0;
	private boolean estComplete = false;

	public Mission(String nom) {
		this.nom = nom;
	}
	public Mission(String nom, List<Pilote> pilotes) {
		this.nom = nom;
		this.pilotes = pilotes;
	}
	
	public void endMission() {
		estComplete = true;
	}

	public void  addPilotes(Pilote pilote) {
		this.pilotes.add(pilote);
	}

}
