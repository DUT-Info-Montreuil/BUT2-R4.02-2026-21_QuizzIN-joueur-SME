package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.Mocks;

import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IJoueurService;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class creerJoueurOkMock implements IJoueurService {
    @Override
    public JoueurDTO creerJoueur(String prenom, String pseudo, int anneeNaissance, List<String> centresInteret, int languePreferee) {
        // Renvoie un faux joueur créé avec succès
        return new JoueurDTO(prenom, pseudo, anneeNaissance, null, "Sport", new ArrayList<>());
    }

    @Override
    public List<JoueurDTO> afficherJoueurs() {
        return null;
    }
}