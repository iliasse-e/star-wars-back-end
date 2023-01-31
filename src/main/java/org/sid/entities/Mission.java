package org.sid.entities;

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
	@Column
	private String nom;

	@OneToMany
	@Column(nullable = false)
	private List<Pilote> pilotes;

	@Column(nullable = false)
	private int nbHeureMission;

	@Column(nullable = false)
	private boolean estComplete = false;

	//------------------------------------------------------
	// CONSTRUCTEUR
	//------------------------------------------------------

	

	//------------------------------------------------------
	// METHODES
	//------------------------------------------------------
	
	public void endMission() {
		estComplete = true;
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
}
