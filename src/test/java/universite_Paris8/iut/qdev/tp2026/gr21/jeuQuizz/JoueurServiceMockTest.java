package universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.Mocks.*;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.entities.dtos.JoueurDTO;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.impls.JoueurServiceImpl;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.services.interfaces.IJoueurService;
import universite_Paris8.iut.qdev.tp2026.gr21.jeuQuizz.utils.exceptions.*;

public class JoueurServiceMockTest {

    private IJoueurService joueurService;

    @BeforeEach
    public void setUp() {
        joueurService = new JoueurServiceImpl();
    }

    @Test
    public void testAucunJoueur() {
        joueurService = new listerJoueursKoZeroJoueursMock();
        Exception exception = assertThrows(AucunJoueurEnregistreException.class, () -> {
            joueurService.listerJoueurs();
        });
    }

    @Test
    public void testCreerJoueur_PseudoInvalide() {
        joueurService = new creerJoueurKoPseudoInvalideMock();
        Exception exception = assertThrows(PseudoInvalideException.class, () -> {
            joueurService.creerJoueur("Anis", "1Anis", 2004, Arrays.asList("Jeux"), 1);
        });
    }

    @Test
    public void testCreerJoueur_PseudoExistant() {
        joueurService = new creerJoueurKoPseudoExistantMock();
        Exception exception = assertThrows(PseudoExistantException.class, () -> {
            joueurService.creerJoueur("Fousseyni", "Fouss", 2003, Arrays.asList("Code"), 2);
        });
    }

    @Test
    public void testCreerJoueur_CasNominal() {
        joueurService = new creerJoueurOkMock();
        try {
            JoueurDTO resultat = joueurService.creerJoueur("Ahmed", "Moulai", 2002, Arrays.asList("Cinéma"), 3);
            assertNotNull(resultat);
            assertEquals("Ahmed", resultat.getPrenom());
            assertEquals("Moulai", resultat.getPseudo());
        } catch(Exception e){
            fail("Should not have thrown any exception");
        }
    }

    @Test
    public void testCreerJoueur_LangueTropBasse() {
        joueurService = new creerJoueurKoLangueTropBasseMock();
        Exception exception = assertThrows(LangueInvalideException.class, () -> {
            joueurService.creerJoueur("Anis", "Anis21", 2004, Arrays.asList("Jeux"), 0);
        });
    }

    @Test
    public void testCreerJoueur_LangueTropHaute() {
        joueurService = new creerJoueurKoLangueTropHauteMock();
        Exception exception = assertThrows(LangueInvalideException.class, () -> {
            joueurService.creerJoueur("Fousseyni", "Fouss", 2003, Arrays.asList("Sport"), 6);
        });
    }

    @Test
    public void testAfficherPlusieursJoueurs_CasNominal() throws Exception {
        joueurService = new listerPlusieursJoueursOkMock();
        List<JoueurDTO> listeResultat = joueurService.listerJoueurs();

        assertNotNull(listeResultat);
        assertEquals(3, listeResultat.size(), "La liste doit retourner exactement 3 joueurs.");
        assertEquals("Anis21", listeResultat.get(0).getPseudo());
        assertEquals("Fouss", listeResultat.get(1).getPseudo());
        assertEquals("Moulai", listeResultat.get(2).getPseudo());
    }

    @Test
    public void testCreerJoueur_SansCentresInteret() throws Exception {
        joueurService = new creerJoueurOkChampsVidesMock();
        JoueurDTO resultat = joueurService.creerJoueur("Ahmed", "Moulai", 2002, Arrays.asList(), 1);

        assertNotNull(resultat);
        assertEquals("", resultat.getCentreInterets(), "La chaîne des centres d'intérêt doit être vide.");
    }

    @Test
    public void testFournirStatsJoueur_CasNominal() throws Exception {
        joueurService = new fournirStatsJoueurOkMock();
        List<Object> stats = joueurService.fournirStatsJoueur("Moulai");

        assertNotNull(stats);
        assertEquals(3, stats.size(), "La liste de scores doit contenir 3 entrées.");
    }

    @Test
    public void testFournirStatsJoueur_AucunJoueurEnregistre() {
        joueurService = new fournirStatsJoueurKoAucunJoueurMock();
        assertThrows(AucunJoueurEnregistreException.class, () -> {
            joueurService.fournirStatsJoueur("Moulai");
        });
    }

    @Test
    public void testFournirStatsJoueur_JoueurInexistant() {
        joueurService = new fournirStatsJoueurKoJoueurInexistantMock();
        assertThrows(AucunJoueurEnregistreException.class, () -> {
            joueurService.fournirStatsJoueur("PseudoInconnu");
        });
    }
}
