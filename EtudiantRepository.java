import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Etudiant;

public class EtudiantRepository {
    // Déclaration des informations de connexion à la base de données
    private static final String URL = "jdbc:mysql://localhost:3306/ism_2024";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private EtudiantRepository etudiantRepository = new EtudiantRepository();

    // Méthode pour ajouter un étudiant
    public void addEtudiant(Etudiant etudiant) {
        etudiantRepository.insert(etudiant);
    }

    private void insert(Etudiant etudiant) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    // Méthode pour lister tous les étudiants
    public List<Etudiant> listerEtudiants() {
          return etudiantRepository.selectAll();
    }

    private List<Etudiant> selectAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectAll'");
    }

    // Méthode pour lister les étudiants par matricule
    public List<Etudiant> listerEtudiantsParMatricule(String matricule) {
        return etudiantRepository.selectByMatricule(matricule);
    }

    private List<Etudiant> selectByMatricule(String matricule) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectByMatricule'");
    }
}

