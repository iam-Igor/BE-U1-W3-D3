package igor.entities;

import com.sun.istack.Nullable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("partita")
public class PartitaDICalcio extends Evento {

    private String squadraDiCasa;
    private String squadraOspite;

    @Nullable
    private String squadraVincente;

    private int goalSquadracasa;
    private int getGoalSquadraOspite;


    public PartitaDICalcio() {

    }

    public PartitaDICalcio(String title, String dataEvento, EventType eventType, double maxParticipants, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int goalSquadracasa, int getGoalSquadraOspite) {
        super(title, dataEvento, eventType, maxParticipants, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.goalSquadracasa = goalSquadracasa;
        this.getGoalSquadraOspite = getGoalSquadraOspite;
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
                ", getGoalSquadraOspite=" + getGoalSquadraOspite +
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
        return getGoalSquadraOspite;
    }

    public void setGetGoalSquadraOspite(int getGoalSquadraOspite) {
        this.getGoalSquadraOspite = getGoalSquadraOspite;
    }
}
