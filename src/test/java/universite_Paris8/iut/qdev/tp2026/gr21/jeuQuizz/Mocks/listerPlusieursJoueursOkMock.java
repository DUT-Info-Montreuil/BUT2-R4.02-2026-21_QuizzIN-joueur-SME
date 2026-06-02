package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.Mocks;

import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IJoueurService;

import java.util.ArrayList;
import java.util.List;

public class listerPlusieursJoueursOkMock implements IJoueurService {
    @Override
    public JoueurDTO creerJoueur(String prenom, String pseudo, int anneeNaissance, List<String> centresInteret, int languePreferee) {
        return null;
    }

    @Override
    public List<JoueurDTO> afficherJoueurs() {
        List<JoueurDTO> joueurs = new ArrayList<>();
        // On simule le renvoi d'une liste contenant 3 joueurs distincts
        joueurs.add(new JoueurDTO("Anis", "Anis21", 2004, null, "Jeux", new ArrayList<>()));
        joueurs.add(new JoueurDTO("Fousseyni", "Fouss", 2003, null, "Sport", new ArrayList<>()));
        joueurs.add(new JoueurDTO("Ahmed", "Moulai", 2002, null, "Cinéma", new ArrayList<>()));
        return joueurs;
    }
}