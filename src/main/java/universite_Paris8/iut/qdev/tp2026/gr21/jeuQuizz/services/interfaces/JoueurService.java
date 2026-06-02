package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces;

import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuiz.entities.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuiz.utils.exceptions.AucunJoueurEnregistreException;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuiz.utils.exceptions.LangueInvalideException;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuiz.utils.exceptions.PseudoExistantException;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuiz.utils.exceptions.PseudoInvalideException;

import java.util.List;

public interface JoueurService {

    /**
     * Transmet les informations d'un utilisateur afin de crÃ©er un joueur.
     *
     * @param prenom           PrÃ©nom du joueur
     * @param pseudo           Pseudo unique (ne doit pas commencer par un chiffre)
     * @param anneeNaissance   AnnÃ©e de naissance du joueur
     * @param centresInteret   Liste des centres d'intÃ©rÃªt
     * @param languePreferee   Choix de la langue (compris entre 1 et 5)
     * @return Le JoueurDTO crÃ©Ã©
     * @throws PseudoExistantException Si le pseudo est dÃ©jÃ  utilisÃ© par un autre joueur
     * @throws PseudoInvalideException Si le pseudo commence par un chiffre
     * @throws LangueInvalideException Si le choix de la langue n'est pas compris entre 1 et 5
     */
    JoueurDTO creerJoueur(String prenom, String pseudo, int anneeNaissance,
                          List<String> centresInteret, int languePreferee)
            throws PseudoExistantException, PseudoInvalideException, LangueInvalideException;

    /**
     * RÃ©cupÃ¨re la liste de tous les joueurs enregistrÃ©s afin de les afficher.
     *
     * @return La liste des JoueurDTO
     * @throws AucunJoueurEnregistreException Si la liste des joueurs est vide
     */
    List<JoueurDTO> afficherJoueurs() throws AucunJoueurEnregistreException;
}