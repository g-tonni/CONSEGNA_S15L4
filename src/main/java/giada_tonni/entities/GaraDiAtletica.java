package giada_tonni.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("gara_atletica")
public class GaraDiAtletica extends Evento {
    @OneToOne
    @JoinColumn(
            name = "vincitore_partecipazione_id"
    )
    private Partecipazione vincitore;

    public GaraDiAtletica(){}

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int maxPersone, Location location, Partecipazione vincitore ){
        super(titolo, dataEvento, descrizione, tipoEvento, maxPersone, location);
        this.vincitore = vincitore;
    }

    public Partecipazione getVincitore() {
        return vincitore;
    }

    public void setVincitore(Partecipazione vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "eventoId=" + this.getId() +
                ", titolo='" + this.getTitolo()+ '\'' +
                ", dataEvento=" + this.getDataEvento() +
                ", descrizione='" + this.getDescrizione() + '\'' +
                ", tipoEvento=" + this.getTipoEvento() +
                ", maxPersone=" + this.getMaxPersone() +
                ", location=" + this.getLocation() +
                ", vincitore=" + vincitore +
                '}';
    }
}
