import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.inscription;

public class InscriptionRepository {
    // Déclaration des informations de connexion à la base de données
    private static final String URL = "jdbc:mysql://localhost:3306/nom_de_votre_base_de_donnees";
    private static final String USERNAME = "votre_nom_d_utilisateur";
    private static final String PASSWORD = "votre_mot_de_passe";

    // Méthode pour insérer une inscription dans la base de données
    public void insert(repository.Inscription inscription) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Inscription (id_etudiant, id_classe, date, montant, annee_scolaire) VALUES (?, ?, ?, ?, ?)")) {
            
            // Set the parameters of the prepared statement
            preparedStatement.setInt(1, inscription.getIdEtudiant());
            preparedStatement.setInt(2, inscription.getIdClasse());
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
    public List<inscription> selectAll() {
        List<inscription> inscriptions = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inscription");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            // Process the result set and create Inscription objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idEtudiant = resultSet.getInt("id_etudiant");
                int idClasse = resultSet.getInt("id_classe");
                Date date = resultSet.getDate("date");
                double montant = resultSet.getDouble("montant");
                String anneeScolaire = resultSet.getString("annee_scolaire");

                inscription inscription = new Inscription(id, idEtudiant, idClasse, date, montant, anneeScolaire);
                inscriptions.add(inscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inscriptions;
    }
}



