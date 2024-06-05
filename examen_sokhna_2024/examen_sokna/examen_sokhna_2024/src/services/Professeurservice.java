package services;

import java.util.ArrayList;

import entities.Affectation;
import entities.Classe;
import entities.Professeur;
import repository.ProfesseurRepository;

public class Professeurservice {
    // Définir tous les cas d'utilisation (fonctions) relatifs au professeur

    // Définir une dépendance
    // La couche service dépend de la couche repository
    // Créer un objet de type repository dans la classe Service
    private ProfesseurRepository professeurRepository = new ProfesseurRepository();

    // Ajouter un professeur dans une liste à partir du Repo
    // Insérer un professeur dans la table professeur de la BD à partir du Repo
    public void ajouterProfesseur(Professeur professeur) {
        professeurRepository.insert(professeur);
    }

    // Lister les professeurs de la Liste à partir du Repo
    // Sélectionner les professeurs dans la table professeur de la BD à partir du Repo
    public ArrayList<Professeur> listerProfesseur(){
        return professeurRepository.selectAll();
    }
    // Recher un professeur de la Liste à partir du Repo
    // Sélectionner un professeur dans la table professeur de la BD à partir du Repo
    public Professeur chercherProfesseur(int id){
        return professeurRepository.selectById(id);
    }

    public void affecterUneClasse(Professeur p, Classe c){
        professeurRepository.assignerClasses(p, c);
    }

    public ArrayList<Affectation> listerLesAffectationDuProfesseur(Professeur p){
        return professeurRepository.selectAllAffectationByProfesseur(p);
    }
}