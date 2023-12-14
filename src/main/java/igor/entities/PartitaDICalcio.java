package igor.entities;

import com.sun.istack.Nullable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@DiscriminatorValue("partita")
@NamedQuery(name = "getPartiteVinteInCasa", query = "SELECT p FROM PartitaDICalcio p WHERE p.goalSquadracasa > p.goalSquadraOspite")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "SELECT p FROM PartitaDICalcio p WHERE p.goalSquadracasa < p.goalSquadraOspite")
@NamedQuery(name = "getPartitePareggiate", query = "SELECT p FROM PartitaDICalcio p WHERE p.goalSquadracasa = p.goalSquadraOspite")
public class PartitaDICalcio extends Evento {

    private String squadraDiCasa;
    private String squadraOspite;

    @Nullable
    private String squadraVincente;

    private int goalSquadracasa;
    private int goalSquadraOspite;


    public PartitaDICalcio() {

    }

    public PartitaDICalcio(String title, String dataEvento, EventType eventType, double maxParticipants, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int goalSquadracasa, int getGoalSquadraOspite) {
        super(title, dataEvento, eventType, maxParticipants, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.goalSquadracasa = goalSquadracasa;
        this.goalSquadraOspite = getGoalSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    @Override
    public String toString() {
        return "PartitaDICalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", goalSquadracasa=" + goalSquadracasa +
                ", getGoalSquadraOspite=" + goalSquadraOspite +
                '}';
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGoalSquadracasa() {
        return goalSquadracasa;
    }

    public void setGoalSquadracasa(int goalSquadracasa) {
        this.goalSquadracasa = goalSquadracasa;
    }

    public int getGetGoalSquadraOspite() {
        return goalSquadraOspite;
    }

    public void setGetGoalSquadraOspite(int getGoalSquadraOspite) {
        this.goalSquadraOspite = getGoalSquadraOspite;
    }
}
