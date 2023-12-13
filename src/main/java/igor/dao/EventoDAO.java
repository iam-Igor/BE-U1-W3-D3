package igor.dao;

import igor.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

}
