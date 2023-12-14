package igor.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("concerto")
@NamedQuery(name = "concertoInStreaming", query = "SELECT c FROM Concerto c WHERE c.inStreaming = true")
@NamedQuery(name = "getGenereConcerto", query = "SELECT c FROM Concerto c WHERE c.genereMusicale = :genere")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    private Genere genereMusicale;

    private boolean inStreaming;


    public Concerto() {
    }

    public Concerto(String title, String dataEvento, EventType eventType, double maxParticipants, Location location, Genere genereMusicale, boolean inStreaming) {
        super(title, dataEvento, eventType, maxParticipants, location);
        this.genereMusicale = genereMusicale;
        this.inStreaming = inStreaming;
    }

    public Genere getGenereMusicale() {
        return genereMusicale;
    }

    public void setGenereMusicale(Genere genereMusicale) {
        this.genereMusicale = genereMusicale;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "Titolo=" + this.getTitle() +
                "genereMusicale=" + genereMusicale +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
