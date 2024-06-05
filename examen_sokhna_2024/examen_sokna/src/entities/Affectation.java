package entities;

public class Affectation {
    private int id;
    private Classe classe;
    private Professeur professeur;
    
    // Constructeur
    public Affectation(int id, Classe classe, Professeur professeur) {
        this.id = id;
        this.classe = classe;
        this.professeur = professeur;
    }
    public Affectation() {
    }

    // Getters et Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    public Professeur getProfesseur() {
        return professeur;
    }
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
    @Override
    public String toString() {
        return "Affectation [id=" + id + ", classe=" + classe.getLibelle() + ", professeur=" + professeur.getNomComplet() + "]";
    }

}
