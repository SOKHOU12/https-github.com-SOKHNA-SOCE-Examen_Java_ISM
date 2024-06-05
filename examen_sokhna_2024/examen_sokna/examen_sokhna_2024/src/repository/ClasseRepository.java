package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Classe;

public class ClasseRepository {
    // Déclaration des informations de connexion à la base de données
    private static final String URL = "jdbc:mysql://localhost/iage_2024";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    // Méthode pour insérer une classe dans la base de données
    public void insert(Classe classe) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO classe (libelle, niveau, filiere) VALUES (?, ?, ?)")) {
            
            // Set the parameters of the prepared statement
            preparedStatement.setString(1, classe.getLibelle());
            preparedStatement.setString(2, classe.getNiveau());
            preparedStatement.setString(3, classe.getFiliere());

            // Execute the insert statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer toutes les classes de la base de données
    public List<Classe> selectAll() {
        List<Classe> classes = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM classe");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            
            // Process the result set and create Classe objects
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String libelle = resultSet.getString("libelle");
                String niveau = resultSet.getString("niveau");
                String filiere = resultSet.getString("filiere");
                
                Classe classe = new Classe();
                classe.setId(id);
                classe.setLibelle(libelle);
                classe.setNiveau(niveau);
                classe.setFiliere(filiere);
                classes.add(classe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }

    // Méthode pour récupérer toutes les classes de la base de données
    public Classe selectOneById(int id) {
        Classe classe = null;
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM classe WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Process the result set and create Classe objects
            if (resultSet.next()) {
                int idClasse = resultSet.getInt("id");
                String libelle = resultSet.getString("libelle");
                String niveau = resultSet.getString("niveau");
                String filiere = resultSet.getString("filiere");
                
                classe = new Classe();
                classe.setId(idClasse);
                classe.setLibelle(libelle);
                classe.setNiveau(niveau);
                classe.setFiliere(filiere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classe;
    }

    
}
