package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces;

import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.AucunJoueurEnregistreException;
import java.util.List;

public interface IStatJoueurInterface {

    List<Object> fournirStatsJoueur(String pseudo) throws AucunJoueurEnregistreException;

}