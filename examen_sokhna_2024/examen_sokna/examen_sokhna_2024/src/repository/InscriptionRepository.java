package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Classe;
import entities.Etudiant;
import entities.Inscription;

public class InscriptionRepository {
    // Déclaration des informations de connexion à la base de données
    private static final String URL = "jdbc:mysql://localhost/iage_2024";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // Méthode pour insérer une inscription dans la base de données
    public void insert(Inscription inscription) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO inscription (id_etudiant, id_classe, date, montant, annee_scolaire) VALUES (?, ?, ?, ?, ?)")) {
            
            // Set the parameters of the prepared statement
            preparedStatement.setInt(1, inscription.getEtudiant().getId());
            preparedStatement.setInt(2, inscription.getClasse().getId());
            preparedStatement.setDate(3, inscription.getDate());
            preparedStatement.setDouble(4, inscription.getMontant());
            preparedStatement.setString(5, inscription.getAnneeScolaire());

            // Execute the insert statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer toutes les inscriptions de la base de données
    public List<Inscription> selectAll() {
        List<Inscription> inscriptions = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM inscription");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            // Process the result set and create Inscription objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idEtudiant = resultSet.getInt("id_etudiant");
                int idClasse = resultSet.getInt("id_classe");
                Date date = resultSet.getDate("date");
                double montant = resultSet.getDouble("montant");
                String anneeScolaire = resultSet.getString("annee_scolaire");

                Inscription inscription = new Inscription();
                inscription.setId(id);
                inscription.setEtudiant(new Etudiant(idEtudiant));
                inscription.setClasse(new Classe(idClasse));
                inscription.setDate(date);
                inscription.setMontant(montant);
                inscription.setAnneeScolaire(anneeScolaire);
                inscriptions.add(inscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inscriptions;
    }

    // Méthode pour récupérer toutes les inscriptions d'une classe de la base de données
    public List<Inscription> selectAllByClasse(Classe classe) {
        List<Inscription> inscriptions = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM inscription WHERE id_classe=?");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            preparedStatement.setInt(1, classe.getId());
            // Process the result set and create Inscription objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idEtudiant = resultSet.getInt("id_etudiant");
                Date date = resultSet.getDate("date");
                double montant = resultSet.getDouble("montant");
                String anneeScolaire = resultSet.getString("annee_scolaire");

                Inscription inscription = new Inscription();
                inscription.setId(id);
                inscription.setEtudiant(new Etudiant(idEtudiant));
                inscription.setClasse(classe);
                inscription.setDate(date);
                inscription.setMontant(montant);
                inscription.setAnneeScolaire(anneeScolaire);
                inscriptions.add(inscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inscriptions;
    }
}

