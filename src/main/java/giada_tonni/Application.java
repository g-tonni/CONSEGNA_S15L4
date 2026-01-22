package giada_tonni;

import giada_tonni.DAO.EventiDAO;
import giada_tonni.DAO.LocationsDAO;
import giada_tonni.DAO.PartecipazioniDAO;
import giada_tonni.DAO.PersoneDAO;
import giada_tonni.entities.*;
import giada_tonni.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("consegnas15l4pu");

    public static void main(String[] args) {

        EntityManager entityManager = emf.createEntityManager();

        EventiDAO ed = new EventiDAO(entityManager);
        PersoneDAO perd = new PersoneDAO(entityManager);
        LocationsDAO ld = new LocationsDAO(entityManager);
        PartecipazioniDAO pard = new PartecipazioniDAO(entityManager);

        LocalDate d1 = LocalDate.of(2026, 2, 1);

        Location stadio1 = new Location("Stadio Olimpico", "Roma");
        Location stadio2 = new Location("San Siro", "Milano");
        Location campo1 = new Location("Campo atletico", "Firenze");
        Location campo2 = new Location("Campo atletico 2", "Napoli");
        Location atlantico = new Location("Atlantico", "Roma");
        Location palalottomatica = new Location("Palalottomatica", "Roma");
/*        ld.save(stadio1);
        ld.save(stadio2);
        ld.save(campo1);
        ld.save(campo2);
        ld.save(atlantico);
        ld.save(palalottomatica);*/

        try {
            Location stadioTrovato1 = ld.findLocationById("0f764d37-057d-44b7-a4d8-9fd662b81f34");
            Location stadioTrovato2 = ld.findLocationById("f4436c1a-c0b5-4941-8995-ac55844037df");
            Location campoTrovato1 = ld.findLocationById("61f368fc-b9e7-424e-a7b2-b972b971be1e");
            Location campoTrovato2 = ld.findLocationById("4d353b10-25d1-442e-ae9b-c3e13051c875");
            Location atlanticoTrovato = ld.findLocationById("f4db3b5d-b7cb-4efc-ab51-a6d8f76939f4");
            Location palaTrovato = ld.findLocationById("6e24b1c5-aff8-4ada-b796-ae7a08e3754e");

            PartitaDiCalcio partita1 = new PartitaDiCalcio("Roma-Juve", d1, "Bellissima partita", TipoEvento.PRIVATO, 300, stadioTrovato1, "Roma", "Juve", 2, 4);
            PartitaDiCalcio partita2 = new PartitaDiCalcio("Milan-Napoli", d1, "Bellissima partita milanese", TipoEvento.PUBBLICO, 500, stadioTrovato2, "Milan", "Napoli", 3, 2);
            // GaraDiAtletica e3 = new GaraDiAtletica("Ginnastica Artistica", d1, "Bravissime ginnaste", TipoEvento.PRIVATO, 200, campoTrovato1, );
            // GaraDiAtletica e4 = new GaraDiAtletica("Corsa", d1, "Bravissimi atleti", TipoEvento.PRIVATO, 200, campoTrovato2);
            Concerto concerto1 = new Concerto("Salmo", d1, "Concerto stupendo", TipoEvento.PRIVATO, 200, atlanticoTrovato, Genere.POP, true);
            Concerto concerto2 = new Concerto("Ligabue", d1, "Concerto molto bello", TipoEvento.PRIVATO, 200, palaTrovato, Genere.POP, false);
        /*    ed.save(partita1);
            ed.save(partita2);
            ed.save(concerto1);
            ed.save(concerto2);*/
        } catch (NotFoundException ex){
            System.out.println(ex.getMessage());
        }

/*
        Persona p1 = new Persona("Giada", "Tonni", "gtonni@gmail.com", Sesso.F);
        Persona p2 = new Persona("Mario", "Rossi", "mrossi@gmail.com", Sesso.M);
        Persona p3 = new Persona("Luigi", "Bianchi", "lbianchi@gmail.com", Sesso.M);
        perd.save(p1);
        perd.save(p2);
        perd.save(p3);


        try {
            Evento eventoTrovato1 = ed.findEventoById("347f07ad-bbfe-47a9-a9e0-1b8f2624ea0e");
            System.out.println(eventoTrovato1);
            Persona personaTrovata1 = perd.findPersonaById("6016857c-8da0-498e-8794-6679b18f2321");
            System.out.println(personaTrovata1);
            Partecipazione partecipazione1 = new Partecipazione(StatoPartecipazione.CONFERMATA, eventoTrovato1, personaTrovata1);
            pard.save(partecipazione1);
        } catch (NotFoundException ex){
            System.out.println(ex.getMessage());
        }

*/


        emf.close();
        entityManager.close();
    }
}
