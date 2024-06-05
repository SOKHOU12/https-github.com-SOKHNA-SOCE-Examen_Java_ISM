package entities;

public class Professeur {
        private int id;
        private String nci;
        private String nomComplet;
        private String grade;
    
        // Constructeur
        public Professeur(int id, String nci, String nomComplet, String grade) {
            this.id = id;
            this.nci = nci;
            this.nomComplet = nomComplet;
            this.grade = grade;
        }
    
        public Professeur() {
            //TODO Auto-generated constructor stub
        }

        // Getters et Setters
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getNci() {
            return nci;
        }
    
        public void setNci(String nci) {
            this.nci = nci;
        }
    
        public String getNomComplet() {
            return nomComplet;
        }
    
        public void setNomComplet(String nomComplet) {
            this.nomComplet = nomComplet;
        }
    
        public String getGrade() {
            return grade;
        }
    
        public void setGrade(String grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "Professeur [id=" + id + ", nci=" + nci + ", nomComplet=" + nomComplet + ", grade=" + grade + "]";
        }
    }
    

