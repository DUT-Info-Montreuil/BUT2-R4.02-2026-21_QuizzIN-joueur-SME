package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.Mocks;

import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IJoueurService;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.*;

import java.util.List;

public class creerJoueurKoPseudoExistantMock implements IJoueurService {
    @Override
    public JoueurDTO creerJoueur(String prenom, String pseudo, int anneeNaissance, List<String> centresInteret, int languePreferee) throws PseudoExistantException {
        throw new PseudoExistantException("ERROR: Blaze existant");
    }

    @Override
    public List<JoueurDTO> afficherJoueurs() {
        return null;
    }
}