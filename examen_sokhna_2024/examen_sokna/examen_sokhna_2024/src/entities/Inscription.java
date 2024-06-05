package entities;
import java.sql.Date;;

public class Inscription {

    private int id;
    private Etudiant etudiant;
    private Classe Classe;
    private Date date;
    private double montant;
    private String anneeScolaire;
    


    // Constructeurs
    public Inscription() {
    }

    public Inscription(int id, Etudiant etudiant, Classe classe, Date date, double montant, String anneeScolaire) {
        this.id = id;
        this.etudiant = etudiant;
        Classe = classe;
        this.date = date;
        this.montant = montant;
        this.anneeScolaire = anneeScolaire;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Classe getClasse() {
        return Classe;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setClasse(Classe classe) {
        Classe = classe;
    }
    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    @Override
    public String toString() {
        return "Inscription [id=" + id + ", etudiant=" + etudiant.getNomComplet() + ", Classe=" + Classe.getLibelle() + ", date=" + date.toString()
                + ", montant=" + montant + ", anneeScolaire=" + anneeScolaire + "]";
    }
}


