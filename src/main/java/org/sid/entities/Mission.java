package org.sid.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class Mission {

	//------------------------------------------------------
	// ATTRIBUTS
	//------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mission", updatable = false)
	private Long id;

	@Column(nullable = false)
	private String nom;

	@OneToMany
	@Column(nullable = false)
	private List<Pilote> pilotes = new ArrayList<Pilote>();


	private int nbHeureMission;

	@Column(nullable = false)
	private boolean estComplete = false;

	//------------------------------------------------------
	// CONSTRUCTEUR
	//------------------------------------------------------

	public Mission() {
	}

	public Mission(String nom) {
		this.nom = nom;
	}

	//------------------------------------------------------
	// METHODES
	//------------------------------------------------------
	
	public void endMission() {
		estComplete = true;
	}

	public void  addPilotes(Pilote pilote) {
		this.pilotes.add(pilote);
	}

	//------------------------------------------------------
	// GETTER & SETTER
	//------------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbHeureMission() {
		return nbHeureMission;
	}

	public void setNbHeureMission(int nbHeureMission) {
		this.nbHeureMission = nbHeureMission;
	}

	public boolean isEstComplete() {
		return estComplete;
	}

	public void setEstComplete(boolean estComplete) {
		this.estComplete = estComplete;
	}

	public List<Pilote> getPilotes() {
		return pilotes;
	}

	public void setPilotes(List<Pilote> pilotes) {
		this.pilotes = pilotes;
	}
}
