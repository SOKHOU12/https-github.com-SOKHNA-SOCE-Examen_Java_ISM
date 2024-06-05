package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Affectation;
import entities.Classe;
import entities.Professeur;

public class ProfesseurRepository {
    // Déclaration des informations de connexion à la base de données
    private static final String URL = "jdbc:mysql://localhost/iage_2024";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
  
    public void insert(Professeur professeur) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO professeur (nci, nom_complet, grade) VALUES (?, ?, ?)")) {
            
            // Set the parameters of the prepared statement
            preparedStatement.setString(1, professeur.getNci());
            preparedStatement.setString(2, professeur.getNomComplet());
            preparedStatement.setString(3, professeur.getGrade());

            // Execute the insert statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void assignerClasses(Professeur professeur, Classe classe) {
        try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO affectation (id_professeur, id_classe) VALUES (?, ?)")){
            
            preparedStatement.setInt(1, professeur.getId());
            preparedStatement.setInt(2, classe.getId());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'assignation des classes au professeur : " + e.getMessage());
        }
    }


    public ArrayList<Affectation> selectAllAffectationByProfesseur(Professeur professeur) {
        ArrayList<Affectation> affectations=new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM affectation WHERE id_professeur=?")) {
            
            // Set the parameters of the prepared statement
            preparedStatement.setInt(1, professeur.getId());
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");

                Affectation affectation = new Affectation(id, new Classe(resultSet.getInt("id_classe")), professeur);
                // 
                affectations.add(affectation);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return affectations;
    }

    public ArrayList<Professeur> selectAll() {
        ArrayList<Professeur> professeurs=new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM professeur")) {
            
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom_complet = resultSet.getString("nom_complet");
                String nci = resultSet.getString("nci");
                String grade = resultSet.getString("grade");

                Professeur professeur = new Professeur();
                professeur.setId(id);
                professeur.setNci(nci);
                professeur.setGrade(grade);
                professeur.setNomComplet(nom_complet);
                // 
                professeurs.add(professeur);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professeurs;
    }

    public Professeur selectById(int id) {
        Professeur professeur=null;

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM professeur WHERE id=?")) {
                
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id_prof = resultSet.getInt("id");
                String nom_complet = resultSet.getString("nom_complet");
                String nci = resultSet.getString("nci");
                String grade = resultSet.getString("grade");

                professeur = new Professeur();
                professeur.setId(id_prof);
                professeur.setNci(nci);
                professeur.setGrade(grade);
                professeur.setNomComplet(nom_complet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professeur;
    }

}

    


