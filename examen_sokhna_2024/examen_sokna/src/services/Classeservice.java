package services;

import java.util.List;

import entities.Classe;
import repository.ClasseRepository;

public class Classeservice {
    
    // Définir tous les cas d'utilisation (fonctions) relatifs à la classe

    // Définir une dépendance
    // La couche service dépend de la couche repository
    // Créer un objet de type repository dans la classe Service
    private  ClasseRepository classeRepository = new ClasseRepository();

    // Ajouter une classe dans une liste à partir du Repo
    // Insérer une classe dans la table classe de la BD à partir du Repo
    public void ajouterClasse(Classe classe) {
        classeRepository.insert(classe);
    }

    // Lister les classes de la Liste à partir du Repo
    // Sélectionner les classes dans la table classe de la BD à partir du Repo
    public List<Classe> listerClasses() {
        return classeRepository.selectAll();
    }

    // Lister les classes de la Liste dont le libellé passé en paramètre
    // Sélectionner les classes dans la table classe de la BD dont le libellé est égal au libellé passé en paramètre
    public Classe chercherUneClasseParId(int id) {
        return classeRepository.selectOneById(id);
    }
}
    