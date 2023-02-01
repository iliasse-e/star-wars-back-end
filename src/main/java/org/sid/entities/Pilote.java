package org.sid.entities;


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
    @Column(name = "id_pilote")
    private Long id;

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
        return (this.sante == Sante.FORME
                && this.missionActuelle == null
                && this.chasseur != null
                && this.chasseur.getDispo());
    }

    public String getGrade() {
        String grade;
        if (this.heureDeVol <= 500) {
            grade = "Officier";
        } else if (this.heureDeVol < 1500 && this.nbMission >= 1) {
            grade = "Lieutenant";
        } else if ((this.heureDeVol < 4000) &&
                (this.heureDeVol >= 1500) &&
                (this.nbMission >= 3)) {
            grade = "Capitaine";
        } else grade = "Commandant";
        return grade;
    }

    //------------------------------------------------------
    // GETTER & SETTER
    //------------------------------------------------------


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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

    public void setChasseur() {
        this.chasseur = null;
    }

    public Mission getMissionActuelle() {
        return missionActuelle;
    }

    public void setMissionActuelle(Mission missionActuelle) {
        this.missionActuelle = missionActuelle;
    }
}
