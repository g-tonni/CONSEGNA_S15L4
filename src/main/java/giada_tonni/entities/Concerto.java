package giada_tonni.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity@DiscriminatorValue("concerto")
public class Concerto extends Evento {

    @Column(name = "genere", nullable = false)
    private Genere genere;

    @Column(name = "in_streaming", nullable = false)
    private boolean inStreaming;

    public Concerto(){}

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int maxPersone, Location location, Genere genere, boolean inStreaming ){
        super(titolo, dataEvento, descrizione, tipoEvento, maxPersone, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
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
                "eventoId=" + this.getId() +
                ", titolo='" + this.getTitolo()+ '\'' +
                ", dataEvento=" + this.getDataEvento() +
                ", descrizione='" + this.getDescrizione() + '\'' +
                ", tipoEvento=" + this.getTipoEvento() +
                ", maxPersone=" + this.getMaxPersone() +
                ", location=" + this.getLocation() +
                ", genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
