package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.Mocks;

import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IJoueurService;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.LangueInvalideException;

import java.util.List;

public class creerJoueurKoLangueTropHauteMock implements IJoueurService {
    @Override
    public JoueurDTO creerJoueur(String prenom, String pseudo, int anneeNaissance, List<String> centresInteret, int languePreferee) throws LangueInvalideException {
        throw new LangueInvalideException("ERROR: langue inconnu - Valeur supérieure à 5");
    }

    @Override
    public List<JoueurDTO> afficherJoueurs() {
        return null;
    }
}