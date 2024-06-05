import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import entities.Professeur;

public class professeurRepository extends Database {
  
    public Professeur insert(Professeur professeur) {
        String sql = "INSERT INTO Professeur (NCI, nom_complet, grade) VALUES (?, ?, ?)";
        try {
            ouvrirConnexion();
            initPrepareStatement(sql);
            PreparableStatement.setString(1, professeur.getNCI());
            PreparableStatement.setString(2, professeur.getNomComplet());
            PreparableStatement.setString(3, professeur.getGrade());
            executeUpdate();
            return professeur;
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'insertion du professeur : " + e.getMessage());
            return null;
        } finally {
            fermerConnexion();
        }
    }

    private void executeUpdate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeUpdate'");
    }

    private void initPrepareStatement(String sql) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initPrepareStatement'");
    }

    private void ouvrirConnexion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ouvrirConnexion'");
    }

    public void assignerClasses(int professeurId, List<Integer> classeIds) {
        String sql = "INSERT INTO affectation (id_professeur, id_classe) VALUES (?, ?)";
        try {
            ouvrirConnexion();
            initPrepareStatement(sql);
            for (Integer classeId : classeIds) {
                PreparableStatement.setInt(1, professeurId);
                preparedStatement.setInt(2, classeId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'assignation des classes au professeur : " + e.getMessage());
        } finally {
            fermerConnexion();
        }
    }
}

    


