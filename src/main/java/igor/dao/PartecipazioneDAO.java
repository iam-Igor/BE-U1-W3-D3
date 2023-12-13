package igor.dao;

import igor.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {

    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Partecipazione partecipazione) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(partecipazione);
        transaction.commit();

        System.out.println(partecipazione + " aggiunta!");
    }


    public Partecipazione findById(long id) {

        return em.find(Partecipazione.class, id);
    }


    public void findByIdAndDelete(long id) {

        Partecipazione found = this.findById(id);

        if (found != null) {


            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("Partecipazione eliminata!");

        } else {
            System.out.println("La partecipazione con l'id " + id + " non è stata trovata");
        }


    }

}
