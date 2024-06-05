package services;

import java.util.List;
import entities.Etudiant;
import repository.EtudiantRepository;

public class Etudiantservice {
    // Définir tous les cas d'utilisation (fonctions) relatifs à l'étudiant

    // Définir une dépendance
    // La couche service dépend de la couche repository
    // Créer un objet de type repository dans la classe Service
    private EtudiantRepository etudiantRepository = new EtudiantRepository();

    // Ajouter un étudiant dans une liste à partir du Repo
    // Insérer un étudiant dans la table étudiant de la BD à partir du Repo
    public void ajouterEtudiant(Etudiant etudiant) {
        etudiantRepository.insert(etudiant);
    }

    // Lister les étudiants de la Liste à partir du Repo
    // Sélectionner les étudiants dans la table étudiant de la BD à partir du Repo
    public List<Etudiant> listerEtudiants() {
        return etudiantRepository.selectAll();
    }

    // Lister les étudiants de la Liste dont le matricule passé en paramètre
    // Sélectionner les étudiants dans la table étudiant de la BD dont le matricule est égal au matricule passé en paramètre
    public Etudiant listerEtudiantParMatricule(String matricule) {
        return etudiantRepository.selectByMatricule(matricule);
    }

    // Lister les étudiants de la Liste dont le matricule passé en paramètre
    // Sélectionner les étudiants dans la table étudiant de la BD dont le matricule est égal au matricule passé en paramètre
    public Etudiant dernierEtudiant() {
        return etudiantRepository.selectDernierEtudiant();
    }
}

