package org.sid.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Mission {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	//@OneToMany
	//private List<Chasseur> chasseurs;
	@OneToMany
	private List<Pilote> pilotes;
	private int nbHeureMission;
	private boolean estComplete = false;
	
	public void endMission() {
		estComplete = true;
	}
}
