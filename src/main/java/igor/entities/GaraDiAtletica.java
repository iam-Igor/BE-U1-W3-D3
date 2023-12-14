package igor.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("gara_atletica")
public class GaraDiAtletica extends Evento {

    @OneToMany(mappedBy = "garaDiAtletica")
    private Set<Persona> atleti;
    @OneToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;


    public GaraDiAtletica() {

    }

    public GaraDiAtletica(String title, String dataEvento, EventType eventType, double maxParticipants, Location location, Set<Persona> atleti, Persona vincitore) {
        super(title, dataEvento, eventType, maxParticipants, location);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
