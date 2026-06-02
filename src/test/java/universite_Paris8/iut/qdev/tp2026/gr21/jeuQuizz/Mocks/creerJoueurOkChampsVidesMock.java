package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.Mocks;

import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IJoueurService;

import java.util.ArrayList;
import java.util.List;

public class creerJoueurOkChampsVidesMock implements IJoueurService {
    @Override
    public JoueurDTO creerJoueur(String prenom, String pseudo, int anneeNaissance, List<String> centresInteret, int languePreferee) {
        // Retourne un joueur valide avec une chaîne vide pour les centres d'intérêt
        return new JoueurDTO(prenom, pseudo, anneeNaissance, null, "", new ArrayList<>());
    }

    @Override
    public List<JoueurDTO> afficherJoueurs() {
        return null;
    }
}