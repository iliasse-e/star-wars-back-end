package org.sid.entities;


import org.sid.enums.Grade;
import org.sid.enums.Race;
import org.sid.enums.Sante;

import javax.persistence.*;

@Entity
@Table
public class Pilote extends Rebelle {
    //------------------------------------------------------
    // ATTRIBUTS
    //------------------------------------------------------
    @Id
    @SequenceGenerator(name = "pilote_generator", sequenceName = "pilote_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pilote_generator")
    @Column(updatable = false)
    private Long id;

    //@Column(nullable = false)
    //private Grade grade;

    private double heureDeVol;
    private int nbMission;

    @Column(nullable = false)
    private Sante sante;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_chasseur")
    private Chasseur chasseur;

    @ManyToOne
    @JoinColumn(name = "id_mission")
    private Mission missionActuelle;


    //------------------------------------------------------
    // CONSTRUCTEURS
    //------------------------------------------------------

    public Pilote() {
        super();
    }

    public Pilote(String prenom, String nom, Race race, int age) {
        super(prenom, nom, race, age);
        this.heureDeVol = 0;
        this.nbMission = 0;
        this.sante = Sante.FORME;
    }


    //------------------------------------------------------
    // METHODES
    //------------------------------------------------------

    public boolean getDispo() {
        return true;
    }

    //------------------------------------------------------
    // GETTER & SETTER
    //------------------------------------------------------

    //public Grade getGrade() {
    //    return grade;
    // }

    public double getHeureDeVol() {
        return heureDeVol;
    }

    public void setHeureDeVol(double heureDeVol) {
        this.heureDeVol = heureDeVol;
    }

    public int getNbMission() {
        return nbMission;
    }

    public void setNbMission(int nbMission) {
        this.nbMission = nbMission;
    }

    public Sante getSante() {
        return sante;
    }

    public void setSante(Sante sante) {
        this.sante = sante;
    }

    public Chasseur getChasseur() {
        return chasseur;
    }

    public void setChasseur(Chasseur chasseur) {
        this.chasseur = chasseur;
    }

    public Mission getMissionActuelle() {
        return missionActuelle;
    }

    public void setMissionActuelle(Mission missionActuelle) {
        this.missionActuelle = missionActuelle;
    }

   // public void setGrade(Grade grade) {
    //    this.grade = grade;
   // }
}
