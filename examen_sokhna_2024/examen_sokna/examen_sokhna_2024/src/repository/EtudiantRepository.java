package repository;

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
    private static final String URL = "jdbc:mysql://localhost/iage_2024";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    
    // Méthode pour ajouter un étudiant
    public void insert(Etudiant etudiant) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO etudiant (matricule, nomComplet, tuteur) VALUES (?, ?, ?)")) {
            
            // Set the parameters of the prepared statement
            preparedStatement.setString(1, etudiant.getMatricule());
            preparedStatement.setString(2, etudiant.getNomComplet());
            preparedStatement.setString(3, etudiant.getTuteur());

            // Execute the insert statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour lister tous les étudiants
    public List<Etudiant> selectAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM etudiant");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            // Process the result set and create Classe objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String matricule = resultSet.getString("matricule");
                String nomComplet = resultSet.getString("nomComplet");
                String tuteur = resultSet.getString("tuteur");
                
                Etudiant etudiant = new Etudiant(id, matricule, nomComplet, tuteur);
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }

    // Méthode pour rechercher un étudiant par matricule
    public Etudiant selectByMatricule(String matricule) {
        Etudiant etudiant = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM etudiant WHERE matricule=?");
            preparedStatement.setString(1, matricule);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Process the result set and create Classe objects
            if (resultSet.next()) {
                etudiant = new Etudiant(resultSet.getInt("id"), resultSet.getString("matricule"), resultSet.getString("nomComplet"), resultSet.getString("tuteur"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }

    // Méthode pour rechercher le dernier etudiant ajouter dans la base de donnees
    public Etudiant selectDernierEtudiant() {
        Etudiant etudiant = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *,MAX(id) FROM etudiant");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Process the result set and create Classe objects
            if (resultSet.next()) {
                etudiant = new Etudiant(resultSet.getInt("id"), resultSet.getString("matricule"), resultSet.getString("nomComplet"), resultSet.getString("tuteur"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiant;
    }

}

