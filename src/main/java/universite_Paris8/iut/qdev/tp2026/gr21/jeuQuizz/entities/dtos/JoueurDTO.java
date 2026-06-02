package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos;

import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.enums.Langue;
import java.util.List;

public class JoueurDTO {
    private String prenom;
    private String pseudo;
    private int anneeNaissance;
    private Langue languePref;
    private String centreInterets;
    private List<Object> listeScore;

    public JoueurDTO() {}

    public JoueurDTO(String prenom, String pseudo, int anneeNaissance, Langue languePref, String centreInterets, List<Object> listeScore) {
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.anneeNaissance = anneeNaissance;
        this.languePref = languePref;
        this.centreInterets = centreInterets;
        this.listeScore = listeScore;
    }

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