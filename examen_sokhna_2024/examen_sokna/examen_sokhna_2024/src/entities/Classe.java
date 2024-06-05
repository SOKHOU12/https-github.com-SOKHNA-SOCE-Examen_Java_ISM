package entities;

import java.util.List;

public class Classe {
    private int id;
    private String libelle;
    private String niveau;
    private String filiere;
    private List<Inscription> inscriptions;
    private List<Professeur> professeurs;

    // Constructeur
    public Classe(int id) {
        this.id = id;
    }

    public Classe(int id, String libelle, String niveau, String filiere) {
        this.id = id;
        this.libelle = libelle;
        this.niveau = niveau;
        this.filiere = filiere;
    }

    public Classe() {
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }


    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public List<Professeur> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    @Override
    public String toString() {
        return "Classe [id=" + id + ", libelle=" + libelle + ", niveau=" + niveau + ", filiere=" + filiere + "]";
    }

}
