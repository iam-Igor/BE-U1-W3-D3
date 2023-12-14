package igor.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gestione_eventi")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipo_evento")
public class Evento {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "titolo")
    private String title;

    @Column(name = "data_evento")
    private String dataEvento;

    @Column(name = "tipo_evento")
    @Enumerated(EnumType.STRING)
    private EventType eventType;

    @Column(name = "max_partecipanti")
    private double maxParticipants;

    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;


    public Evento(String title, String dataEvento, EventType eventType, double maxParticipants, Location location) {
        this.title = title;
        this.dataEvento = dataEvento;
        this.eventType = eventType;
        this.maxParticipants = maxParticipants;
        this.location = location;

    }

    public Evento() {

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = String.valueOf(dataEvento);
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public double getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(double maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dataEvento='" + dataEvento + '\'' +
                ", eventType=" + eventType +
                ", maxParticipants=" + maxParticipants +
                ", location=" + location +
                '}';
    }
}
