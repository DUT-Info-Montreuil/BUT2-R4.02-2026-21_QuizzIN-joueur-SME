package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.impls;

import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IJoueurService;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.enums.LangueEnum;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.AucunJoueurEnregistreException;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.LangueInvalideException;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.PseudoExistantException;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.PseudoInvalideException;

import java.util.ArrayList;
import java.util.List;

public class JoueurServiceImpl implements IJoueurService {

    private List<JoueurDTO> listeJoueurs;

    public JoueurServiceImpl() {
        this.listeJoueurs = new ArrayList<>();
    }

    @Override
    public JoueurDTO creerJoueur(String prenom, String pseudo, int anneeNaissance, List<String> centresInteret, int languePreferee) throws PseudoExistantException, PseudoInvalideException, LangueInvalideException {
        if (pseudo != null && !pseudo.isEmpty() && Character.isDigit(pseudo.charAt(0))) {
            throw new PseudoInvalideException("Erreur : Blaze inco - Le pseudo commence par un chiffre");
        }

        for (JoueurDTO joueur : listeJoueurs) {
            if (joueur.getPseudo().equalsIgnoreCase(pseudo)) {
                throw new PseudoExistantException("ERROR: Blaze existant");
            }
        }

        if (languePreferee < 1 || languePreferee > 5) {
            throw new LangueInvalideException("ERROR: langue inconnu");
        }

        LangueEnum langueChoisie = null;
        switch (languePreferee) {
            case 1:
                langueChoisie = LangueEnum.FRANCAIS;
                break;
            case 2:
                langueChoisie = LangueEnum.ENGLISH;
                break;
            case 3:
                langueChoisie = LangueEnum.ESPANA;
                break;
            case 4:
                langueChoisie = LangueEnum.DEUTCH;
                break;
            case 5:
                langueChoisie = LangueEnum.ITALIA;
                break;
        }

        String centresInteretFormat = String.join(", ", centresInteret);

        JoueurDTO nouveauJoueur = new JoueurDTO(prenom, pseudo, anneeNaissance, langueChoisie, centresInteretFormat, new ArrayList<>());
        listeJoueurs.add(nouveauJoueur);

        return nouveauJoueur;
    }

    @Override
    public List<JoueurDTO> listerJoueurs() throws AucunJoueurEnregistreException {
        if (listeJoueurs.isEmpty()) {
            throw new AucunJoueurEnregistreException("ERROR : pas de joueur");
        }
        return listeJoueurs;
    }
}