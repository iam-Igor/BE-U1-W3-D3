package igor;

import igor.dao.EventoDAO;
import igor.dao.LocationDAO;
import igor.dao.PartecipazioneDAO;
import igor.dao.PersonaDAO;
import igor.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventi");

    public static void main(String[] args) {


//        ESERCIZIO 1

        EntityManager em = emf.createEntityManager();
        EventoDAO sd = new EventoDAO(em);
        PartecipazioneDAO pd = new PartecipazioneDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PersonaDAO persd = new PersonaDAO(em);

        Location forum = new Location("Forum Assago", "Assago");
        Location stadioOlimpico = new Location("Stadio Olimpico", "Roma");

//        ld.save(forum);
//        ld.save(stadioOlimpico);

        Location forumFromDB = ld.findById(36);
        Location stadioFromDB = ld.findById(37);


        Persona atleta1 = new Persona("Rafa", "Leao", "rafaleao@milan.it", "1997-03-01", Sesso.M);
        Persona atleta2 = new Persona("Shelly-Ann", "Fraser-Pryce", "Fraser-Pryce@email.com", "1997-03-01", Sesso.F);

//        persd.save(atleta1);
//        persd.save(atleta2);

        Persona atleta1FromDb = persd.findById(40);
        Persona atleta2FromDb = persd.findById(41);

        Set<Persona> atleti = new HashSet<>();
        atleti.add(atleta1FromDb);
        atleti.add(atleta2FromDb);

        GaraDiAtletica gara1 = new GaraDiAtletica("Olimpiadi", "2023-12-12", EventType.PUBBLICO, 10000, stadioFromDB, atleti, atleta1FromDb);

//        sd.save(gara1);

        System.out.println("La gara 1 di atletica è stata vinta da: " + gara1.getVincitore());

        //-------------CONCERTI-------------------


        Concerto concertoColdplay = new Concerto("Coldplay at Forum", "2024-06-06", EventType.PUBBLICO, 50000, forumFromDB, Genere.POP, false);
        Concerto concertoColdplayInStreaming = new Concerto("Coldplay at Forum(inStreaming)", "2024-06-06", EventType.PUBBLICO, 50000, forumFromDB, Genere.POP, true);

//        sd.save(concertoColdplay);
//        sd.save(concertoColdplayInStreaming);


        List<Concerto> concertiInstreaming = sd.getConcertoInStreaming();
        concertiInstreaming.forEach(System.out::println);

        List<Concerto> concertiPerGenere = sd.getConcertiPerGenere(Genere.POP);
        concertiPerGenere.forEach(System.out::println);


        //       ---------------------------------------ESERCIZIO 2----------------------------------------

        Location stJamesPark = new Location("St James Park", "Newcastle");
        Location sanSiro = new Location("San Siro", "Milano");
        Location gewissStadium = new Location("Gewiss Stadium", "Bergamo");

//        ld.save(stJamesPark);
//        ld.save(sanSiro);
//        ld.save(gewissStadium);

        Location stJamesFromDb = ld.findById(47);
        Location sanSiroFromDb = ld.findById(48);
        Location gewissFromDb = ld.findById(51);


        PartitaDICalcio newcastleVsMilan = new PartitaDICalcio("Newcastle-Milan", "2023-13-12", EventType.PUBBLICO, 60000, stJamesFromDb, "Newcastle", "Milan", "Milan", 1, 2);
        PartitaDICalcio milanVsBorussia = new PartitaDICalcio("Milan-Borussia Dortmund", "2023-01-12", EventType.PUBBLICO, 70000, sanSiroFromDb, "Milan", "Borussia Dortmund", "Borussia Dortmund", 2, 3);
        PartitaDICalcio atalantaVsMilan = new PartitaDICalcio("Atalanta-Milan", "2023-07-12", EventType.PUBBLICO, 30000, gewissFromDb, "Atalanta", "Milan", "Atalanta", 3, 2);
        PartitaDICalcio borussiaVsMilan = new PartitaDICalcio("Borussia Dortmund-Milan", "2023-07-10", EventType.PUBBLICO, 30000, sanSiroFromDb, "Borussia Dortmund", "Milan", null, 0, 0);


//        sd.save(newcastleVsMilan);
//        sd.save(milanVsBorussia);
//        sd.save(atalantaVsMilan);
//        sd.save(borussiaVsMilan);


        List<PartitaDICalcio> partiteVinteInCasa = sd.getPartiteVinteInCasa();
        System.out.println("Partite con squadra di casa vincente:");
        partiteVinteInCasa.forEach(System.out::println);


        List<PartitaDICalcio> partiteVinteIntrasferta = sd.getPartiteVinteInTraferta();
        System.out.println("Partite con squadra ospite vincente:");
        partiteVinteIntrasferta.forEach(System.out::println);


//        ----------------------------EXTRAS-----------------------------------

        List<PartitaDICalcio> partitePari = sd.getPartitePareggiate();
        System.out.println("Partite finite in pareggio:");
        partitePari.forEach(System.out::println);


        List<Persona> vincitoriGareDIAtletica = sd.getVincitoreGara();
        System.out.println("Vincitori delle gare di Atletica:");
        vincitoriGareDIAtletica.forEach(System.out::println);


    }
}
