package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.Mocks.*;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IJoueurService;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.*;

public class JoueurServiceMockTest {

    private IJoueurService joueurService;

    @Test
    public void testAucunJoueur() {
        // 1. Initialisation avec le mock spécifique
        joueurService = new listerJoueursKoZeroJoueursMock();

        // 2. Exécution et vérification
        Exception exception = assertThrows(AucunJoueurEnregistreException.class, () -> {
            joueurService.afficherJoueurs();
        });

    }

    @Test
    public void testCreerJoueur_PseudoInvalide() {
        // 1. Initialisation avec le mock qui simule un pseudo commençant par un chiffre
        joueurService = new creerJoueurKoPseudoInvalideMock();

        // 2. Exécution et vérification
        Exception exception = assertThrows(PseudoInvalideException.class, () -> {
            joueurService.creerJoueur("Anis", "1Anis", 2004, Arrays.asList("Jeux"), 1);
        });

    }

    @Test
    public void testCreerJoueur_PseudoExistant() {
        // 1. Initialisation avec le mock qui simule un doublon
        joueurService = new creerJoueurKoPseudoExistantMock();

        // 2. Exécution et vérification
        Exception exception = assertThrows(PseudoExistantException.class, () -> {
            joueurService.creerJoueur("Fousseyni", "Fouss", 2003, Arrays.asList("Code"), 2);
        });

    }

    @Test
    public void testCreerJoueur_CasNominal() {
        // 1. Initialisation avec le mock qui simule un succès
        joueurService = new creerJoueurOkMock();

        // 2. Exécution
        try {
            JoueurDTO resultat = joueurService.creerJoueur("Ahmed", "Moulai", 2002, Arrays.asList("Cinéma"), 3);
            assertNotNull(resultat);
            assertEquals("Ahmed", resultat.getPrenom());
            assertEquals("Moulai", resultat.getPseudo());
        }catch(Exception e){
            fail("Should not have thrown any exception");
        }

    }


    @Test
    public void testCreerJoueur_LangueTropBasse() {
        // Initialisation avec le mock dédié aux valeurs < 1
        joueurService = new creerJoueurKoLangueTropBasseMock();

        Exception exception = assertThrows(LangueInvalideException.class, () -> {
            joueurService.creerJoueur("Anis", "Anis21", 2004, Arrays.asList("Jeux"), 0); // 0 est invalide
        });

        assertEquals("ERROR: langue inconnu - Valeur inférieure à 1", exception.getMessage());
    }

    @Test
    public void testCreerJoueur_LangueTropHaute() {
        // Initialisation avec le mock dédié aux valeurs > 5
        joueurService = new creerJoueurKoLangueTropHauteMock();

        Exception exception = assertThrows(LangueInvalideException.class, () -> {
            joueurService.creerJoueur("Fousseyni", "Fouss", 2003, Arrays.asList("Sport"), 6); // 6 est invalide
        });

        assertEquals("ERROR: langue inconnu - Valeur supérieure à 5", exception.getMessage());
    }

    @Test
    public void testAfficherPlusieursJoueurs_CasNominal() throws Exception {
        // Initialisation avec le mock retournant plusieurs joueurs
        joueurService = new listerPlusieursJoueursOkMock();

        List<JoueurDTO> listeResultat = joueurService.afficherJoueurs();

        // Assertions et vérifications de la liste complète
        assertNotNull(listeResultat);
        assertEquals(3, listeResultat.size(), "La liste doit retourner exactement 3 joueurs.");
        assertEquals("Anis21", listeResultat.get(0).getPseudo());
        assertEquals("Fouss", listeResultat.get(1).getPseudo());
        assertEquals("Moulai", listeResultat.get(2).getPseudo());
    }

    @Test
    public void testCreerJoueur_SansCentresInteret() throws Exception {
        // Initialisation avec le mock simulant une liste d'intérêts vide
        joueurService = new creerJoueurOkChampsVidesMock();

        JoueurDTO resultat = joueurService.creerJoueur("Ahmed", "Moulai", 2002, Arrays.asList(), 1);

        assertNotNull(resultat);
        assertEquals("", resultat.getCentreInterets(), "La chaîne des centres d'intérêt doit être vide.");
    }
}