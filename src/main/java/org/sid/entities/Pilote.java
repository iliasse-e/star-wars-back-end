package org.sid.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.sid.enums.Race;
import org.sid.enums.Sante;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pilote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private boolean enFormation = true;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Race race;
    private int age;
    private double heureDeVol = 0;
    private int nbMission = 0;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Sante sante = Sante.FORME;
    @OneToOne
    private Chasseur chasseur = null;
    @ManyToOne
    @JoinColumn(name="pilote_id")
    @JsonBackReference
    private Mission missionActuelle = null;

    public Pilote(Long id, String nom, Race race, int age) {    };

    public boolean isMissionReady() {
        return (this.sante == Sante.FORME
                && !isInMission()
                && !this.enFormation
                && hasChasseur());
    }

    public boolean hasChasseur() {
        return chasseur != null;
    }

    public boolean isInMission() {
        return missionActuelle != null;
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
}
