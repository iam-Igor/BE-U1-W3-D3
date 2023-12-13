package igor;

import igor.dao.EventoDAO;
import igor.dao.LocationDAO;
import igor.dao.PartecipazioneDAO;
import igor.dao.PersonaDAO;
import igor.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventi");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        EventoDAO sd = new EventoDAO(em);
        PartecipazioneDAO pd = new PartecipazioneDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PersonaDAO persd = new PersonaDAO(em);


        List<Partecipazione> marioPartecipations = new ArrayList<>();
        List<Partecipazione> peachPartecipations = new ArrayList<>();


//        salvate!
        Location roma = new Location("Villa", "Roma");
        Location paese = new Location("All_city", "Cosenza");


        Location romaFromDB = ld.findById(11);
        Location paeseFromDB = ld.findById(12);


        //        salvate!
        Evento festaInPiscina = new Evento("Festa in piscina", "2023-01-01", EventType.PRIVATO, 200, romaFromDB);
        Evento festaPatronale = new Evento("Festa Patronale", "2024-06-06", EventType.PUBBLICO, 2000, paeseFromDB);


        Evento piscinaFromnDB = sd.findById(29);
        Evento festaPatrFromDB = sd.findById(30);


//        salvate!
        Persona mario = new Persona("Mario", "Bros", "mariobros@nintendo.com", "1970-01-01", Sesso.M, marioPartecipations);
        Persona peach = new Persona("Peach", "Princess", "princesspeach@nintendo.com", "1970-01-01", Sesso.F, peachPartecipations);

        Persona mariofromDB = persd.findById(22);
        Persona peachFromDB = persd.findById(23);

        //salvate!
        Partecipazione uno = new Partecipazione(mariofromDB, festaPatrFromDB, Stato.CONFERMATA);
        Partecipazione due = new Partecipazione(peachFromDB, piscinaFromnDB, Stato.DA_CONFERMARE);


        System.out.println("--------partecipazioni di peach-----------------");
        peachFromDB.getPartecipazioni().forEach(System.out::println);

        System.out.println("--------partecipazioni di mario-----------------");
        mariofromDB.getPartecipazioni().forEach(System.out::println);

    }
}
