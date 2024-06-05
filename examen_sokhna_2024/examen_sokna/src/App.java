import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import entities.Affectation;
import entities.Classe;
import entities.Etudiant;
import entities.Inscription;
import entities.Professeur;
import services.Classeservice;
import services.Etudiantservice;
import services.InscriptionService;
import services.Professeurservice;

public class App {
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int choix;
        Classeservice classeservice=new Classeservice();
        Etudiantservice etudiantservice=new Etudiantservice();
        InscriptionService inscriptionService=new InscriptionService();
        Professeurservice professeurservice=new Professeurservice();

        do {
            System.out.println("\n1.....Ajouter une classe");
            System.out.println("2.....Lister les classes");
            System.out.println("3.....Ajouter un professeur");
            System.out.println("4.....Lister les professeurs");
            System.out.println("5.....Affecter une classe au professeur");
            System.out.println("6.....Lister les classes d'un professeur");
            System.out.println("7.....Faire une inscription");
            System.out.println("8.....Lister les inscriptions");
            System.out.println("0.....Quitter");
            System.out.println("Faites votre choix");
            choix=scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    String libelle, filiere, niveau;
                    System.out.println("Entrer la filiere de la classe");
                    filiere=scanner.nextLine();
                    System.out.println("Entrer le niveau de la classe");
                    niveau=scanner.nextLine();
                    System.out.println("Entrer le libelle de la classe");
                    libelle=scanner.nextLine();
                    
                    Classe classe=new Classe();
                    classe.setFiliere(filiere);
                    classe.setNiveau(niveau);
                    classe.setLibelle(libelle);

                    // ajout de la classe dans la base de donnee
                    classeservice.ajouterClasse(classe);
                    break;
            
                case 2:
                    System.out.println("\nliste des classes");
                    List<Classe> classes=classeservice.listerClasses();
                    for (Classe cl : classes) {
                        System.out.println(cl);
                    }
                    break;

                case 3:
                    String nom, nci, grade;
                    System.out.println("Entrer le nci");
                    nci=scanner.nextLine();
                    System.out.println("Entrer le nom");
                    nom=scanner.nextLine();
                    System.out.println("Entrer le grade");
                    grade=scanner.nextLine();

                    Professeur professeur=new Professeur();
                    professeur.setNci(nci);
                    professeur.setNomComplet(nom);
                    professeur.setGrade(grade);
                    // ajout du professeur dans la base de donnees
                    professeurservice.ajouterProfesseur(professeur);
                    break;

                case 4:
                    System.out.println("\nliste des professeurs");
                    List<Professeur> professeurs=professeurservice.listerProfesseur();
                    for (Professeur prof : professeurs) {
                        System.out.println(prof);
                    }
                    break;

                case 5:
                    System.out.println("Entrer l'id du professeur ");
                    int id_prof=scanner.nextInt();
                    System.out.println("Entrer l'id de la classe ");
                    int id_classe=scanner.nextInt();
                    Professeur p=professeurservice.chercherProfesseur(id_prof);
                    if(p!=null){
                        Classe c=classeservice.chercherUneClasseParId(id_classe);
                        if (c!=null){
                            professeurservice.affecterUneClasse(p, c);
                        }else{
                            System.out.println("erreur de la classe");
                        }
                    }else{
                        System.out.println("erreur du professeur");
                    }
                    break;
                case 6:
                    System.out.println("Entrer l'id du professeur ");
                    int id_p=scanner.nextInt();
                    Professeur prof=professeurservice.chercherProfesseur(id_p);
                    if (prof!=null){
                        List<Affectation> affectations=professeurservice.listerLesAffectationDuProfesseur(prof);
                        for (Affectation affectation : affectations) {
                            Classe classeAffectation=classeservice.chercherUneClasseParId(affectation.getClasse().getId());
                            affectation.setClasse(classeAffectation);

                            System.out.println(affectation);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Entrer le nom de l'etudiant");
                    String nomComplet=scanner.nextLine();
                    System.out.println("Entrer le matricule");
                    String matricule=scanner.nextLine();
                    System.out.println("Entrer le nom du tuteur");
                    String tuteur=scanner.nextLine();
                    
                    Etudiant etudiant=new Etudiant();
                    etudiant.setMatricule(matricule);
                    etudiant.setNomComplet(nomComplet);
                    etudiant.setTuteur(tuteur);
                    // 


                    System.out.println("Entrer l'id de la classe");
                    int idClasse=scanner.nextInt();
                    System.out.println("Entrer le montant");
                    double montant=scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Entrer l'annee scolaire");
                    String anneeScolaire=scanner.nextLine();

                    // on recherche la classe dans la base de donnees
                    Classe cl=classeservice.chercherUneClasseParId(idClasse);
                    if (cl!=null){
                        etudiantservice.ajouterEtudiant(etudiant);
                        etudiant=etudiantservice.dernierEtudiant();
                        // 
                        Inscription inscription=new Inscription();
                        inscription.setAnneeScolaire(anneeScolaire);
                        inscription.setClasse(cl);
                        inscription.setEtudiant(etudiant);
                        inscription.setMontant(montant);
                        inscription.setDate(Date.valueOf(LocalDate.now()));
                        
                        inscriptionService.ajouterInscription(inscription);
                    }else{
                        System.out.println("\nErreur de la classe");
                    }

                    break;

                case 8:
                    System.out.println("Liste des insciptions");
                    List<Inscription> inscriptions=inscriptionService.listerInscriptions();
                    for (Inscription inscription : inscriptions) {
                        System.out.println(inscription);
                    }
                    break;

                default:
                    break;
            }
        } while (choix!=0);
    }
}
