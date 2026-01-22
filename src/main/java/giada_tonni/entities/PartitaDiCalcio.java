package giada_tonni.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("partita_calcio")
public class PartitaDiCalcio extends Evento{

    @Column(name = "squadra_casa", nullable = false)
    private String squadraInCasa;

    @Column(name = "squadra_ospite", nullable = false)
    private String squadraOspite;

    @Column(name = "squadra_vincente")
    private String squadraVincente;

    @Column(name = "n_goal_s_casa", nullable = false)
    private int nGoalCasa;

    @Column(name = "n_goal_s_ospite", nullable = false)
    private int nGoalOspite;

    public PartitaDiCalcio(){}

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int maxPersone, Location location, String squadraInCasa, String squadraOspite, int nGoalCasa, int nGoalOspite){
        super(titolo, dataEvento, descrizione, tipoEvento, maxPersone, location);
        this.squadraInCasa = squadraInCasa;
        this.squadraOspite = squadraOspite;
        this.nGoalCasa = nGoalCasa;
        this.nGoalOspite = nGoalOspite;
        if(nGoalOspite > nGoalCasa){
            this.squadraVincente = squadraOspite;
        } else if (nGoalOspite == nGoalCasa) {
            this.squadraVincente = null;
        } else {
            this.squadraVincente = squadraInCasa;
        }
    }

    public String getSquadraInCasa() {
        return squadraInCasa;
    }

    public void setSquadraInCasa(String squadraInCasa) {
        this.squadraInCasa = squadraInCasa;
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

    public int getnGoalCasa() {
        return nGoalCasa;
    }

    public void setnGoalCasa(int nGoalCasa) {
        this.nGoalCasa = nGoalCasa;
    }

    public int getnGoalOspite() {
        return nGoalOspite;
    }

    public void setnGoalOspite(int nGoalOspite) {
        this.nGoalOspite = nGoalOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "eventoId=" + this.getId() +
                ", titolo='" + this.getTitolo()+ '\'' +
                ", dataEvento=" + this.getDataEvento() +
                ", descrizione='" + this.getDescrizione() + '\'' +
                ", tipoEvento=" + this.getTipoEvento() +
                ", maxPersone=" + this.getMaxPersone() +
                ", location=" + this.getLocation() +
                ", squadraInCasa='" + squadraInCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", nGoalCasa=" + nGoalCasa +
                ", nGoalOspite=" + nGoalOspite +
                '}';
    }
}
