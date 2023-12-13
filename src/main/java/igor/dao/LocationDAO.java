package igor.dao;

import igor.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {

    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Location location) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(location);
        transaction.commit();

        System.out.println(location + " aggiunta!");
    }


    public Location findById(long id) {

        return em.find(Location.class, id);
    }


    public void findByIdAndDelete(long id) {

        Location found = this.findById(id);

        if (found != null) {


            EntityTransaction transaction = em.getTransaction();

            transaction.begin();

            em.remove(found);

            transaction.commit();

            System.out.println("Location " + found.getNome() + " eliminata correttamenta!");

        } else {
            System.out.println("La location con l'id " + id + " non è stata trovata");
        }


    }

}
