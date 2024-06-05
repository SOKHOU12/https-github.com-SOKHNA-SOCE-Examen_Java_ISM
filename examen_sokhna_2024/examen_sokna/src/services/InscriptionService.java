package services;

import java.util.List;

import entities.Classe;
import entities.Inscription;
import repository.InscriptionRepository;

public class InscriptionService {
    // Définir tous les cas d'utilisation (fonctions) relatifs à l'inscription

    // Définir une dépendance
    // La couche service dépend de la couche repository
    // Créer un objet de type repository dans la classe Service
    private InscriptionRepository inscriptionRepository = new InscriptionRepository();

    // Ajouter une inscription dans une liste à partir du Repo
    // Insérer une inscription dans la table inscription de la BD à partir du Repo
    public void ajouterInscription(Inscription inscription) {
        inscriptionRepository.insert(inscription);
    }

    // Lister les inscriptions de la Liste à partir du Repo
    // Sélectionner les inscriptions dans la table inscription de la BD à partir du Repo
    public List<Inscription> listerInscriptions() {
        return inscriptionRepository.selectAll();
    }

    // Lister les inscriptions de la Liste associées à un étudiant donné
    // Sélectionner les inscriptions dans la table inscription de la BD associées à l'ID de l'étudiant passé en paramètre
    public List<Inscription> listerInscriptionsParClasse(Classe classe) {
        return inscriptionRepository.selectAllByClasse(classe);
    }

    // Lister les inscriptions de la Liste associées à une classe donnée
    // Sélectionner les inscriptions dans la table inscription de la BD associées à l'ID de la classe passé en paramètre

    // public List<Inscription> listerInscriptionsParClasse(int id_classe) {
    //     return inscriptionRepository.selectByClasseId(id_classe);
    // }
}

