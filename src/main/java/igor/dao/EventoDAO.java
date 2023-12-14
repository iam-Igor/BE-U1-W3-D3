package igor.dao;

import igor.entities.Concerto;
import igor.entities.Evento;
import igor.entities.Genere;
import igor.entities.PartitaDICalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class EventoDAO {

    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Evento event) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(event);
        transaction.commit();

        System.out.println("Evento " + event + " aggiunto!");
    }


    public Evento findById(long id) {

        return em.find(Evento.class, id);
    }


    public void findByIdAndDelete(long id) {

        Evento found = this.findById(id);

        if (found != null) {


            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("Evento " + found.getTitle() + " eliminato correttamente!");

        } else {
            System.out.println("L'evento con l'id " + id + " non è stato trovato");
        }


    }


    public List<Concerto> getConcertiPerGenere(Genere genere) {

        TypedQuery<Concerto> concertiPerGenere = em.createNamedQuery("getGenereConcerto", Concerto.class);
        concertiPerGenere.setParameter("genere", genere);
        return concertiPerGenere.getResultList();
    }

    public List<Concerto> getConcertoInStreaming() {
        TypedQuery<Concerto> concertoStreaming = em.createNamedQuery("concertoInStreaming", Concerto.class);
        return concertoStreaming.getResultList();
    }


    public List<PartitaDICalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDICalcio> vinteInCasa = em.createNamedQuery("getPartiteVinteInCasa", PartitaDICalcio.class);
        return vinteInCasa.getResultList();
    }

    public List<PartitaDICalcio> getPartiteVinteInTraferta() {
        TypedQuery<PartitaDICalcio> vinteInTrasferta = em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDICalcio.class);
        return vinteInTrasferta.getResultList();
    }

    public List<PartitaDICalcio> getPartitePareggiate() {
        TypedQuery<PartitaDICalcio> partitePari = em.createNamedQuery("getPartitePareggiate", PartitaDICalcio.class);
        return partitePari.getResultList();
    }
}
