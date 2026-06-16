package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.Mocks;

import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IJoueurService;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.AucunJoueurEnregistreException;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.LangueInvalideException;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.PseudoExistantException;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.PseudoInvalideException;

import java.util.Arrays;
import java.util.List;

public class fournirStatsJoueurOkMock implements IJoueurService {

    @Override
    public JoueurDTO creerJoueur(String prenom, String pseudo, int anneeNaissance, List<String> centresInteret, int languePreferee) throws PseudoExistantException, PseudoInvalideException, LangueInvalideException {
        return null;
    }

    @Override
    public List<JoueurDTO> listerJoueurs() throws AucunJoueurEnregistreException {
        return null;
    }

    @Override
    public List<Object> fournirStatsJoueur(String pseudo) throws AucunJoueurEnregistreException {
        return Arrays.asList(150, 200, 175);
    }
}
