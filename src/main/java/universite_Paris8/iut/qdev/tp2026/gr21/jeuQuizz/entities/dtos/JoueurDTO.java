package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos;


import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuiz.utils.enums.Langue;
import java.util.List;

public class JoueurDTO {
    private String prenom;
    private String pseudo;
    private int anneeNaissance;
    private Langue languePref; // TypÃ© en Enum d'aprÃ¨s votre diagramme de conception
    private String centreInterets;
    private List<Object> listeScore; // Ã€ remplacer par List<Score> une fois votre entitÃ© Score crÃ©Ã©e

    // Constructeur vide
    public JoueurDTO() {}

    // Constructeur complet
    public JoueurDTO(String prenom, String pseudo, int anneeNaissance, Langue languePref, String centreInterets, List<Object> listeScore) {
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.anneeNaissance = anneeNaissance;
        this.languePref = languePref;
        this.centreInterets = centreInterets;
        this.listeScore = listeScore;
    }

    // Getters et Setters
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getPseudo() { return pseudo; }
    public void setPseudo(String pseudo) { this.pseudo = pseudo; }

    public int getAnneeNaissance() { return anneeNaissance; }
    public void setAnneeNaissance(int anneeNaissance) { this.anneeNaissance = anneeNaissance; }

    public Langue getLanguePref() { return languePref; }
    public void setLanguePref(Langue languePref) { this.languePref = languePref; }

    public String getCentreInterets() { return centreInterets; }
    public void setCentreInterets(String centreInterets) { this.centreInterets = centreInterets; }

    public List<Object> getListeScore() { return listeScore; }
    public void setListeScore(List<Object> listeScore) { this.listeScore = listeScore; }
}