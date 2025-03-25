package es.cursojava.batalla;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.claseshijas.guerreros.Depredador;
import es.cursojava.clases.claseshijas.guerreros.Mantis;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.excepciones.TooManyFuerzaResistencia;

public class ConfiguracionBatalla {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    public static List<Guerrero> crearMantis(int numGuerreros) {

        List<Guerrero> listaMantis = new CopyOnWriteArrayList<>();

        logger.info("Creando la tripulacion de Mantis...");

        try {
            Mantis mantis1 = new Mantis("Mantis1", "Mantis", 2, 8, "Colmena");
            Mantis mantis2 = new Mantis("Mantis2", "Mantis", 1, 9, "Colmena");
            Mantis mantis3 = new Mantis("Mantis3", "Mantis", 9, 1, "Colmena");
            Mantis mantis4 = new Mantis("Mantis4", "Mantis", 2, 8, "Colmena");
            Mantis mantis5 = new Mantis("Mantis5", "Mantis", 4, 6, "Colmena");
            Mantis mantis6 = new Mantis("Mantis6", "Mantis", 4, 5, "Colmena");
            Mantis mantis7 = new Mantis("Mantis7", "Mantis", 2, 8, "Colmena");
            Mantis mantis8 = new Mantis("Mantis8", "Mantis", 5, 5, "Colmena");
            Mantis mantis9 = new Mantis("Mantis9", "Mantis", 3, 7, "Colmena");
            Mantis mantis10 = new Mantis("Mantis10", "Mantis", 8, 2, "Colmena");

            listaMantis.add(mantis1);
            listaMantis.add(mantis2);
            listaMantis.add(mantis3);
            listaMantis.add(mantis4);
            listaMantis.add(mantis5);
            listaMantis.add(mantis6);
            listaMantis.add(mantis7);
            listaMantis.add(mantis8);
            listaMantis.add(mantis9);
            listaMantis.add(mantis10);

        } catch (TooManyFuerzaResistencia e) {
            e.getMessage();
            e.printStackTrace();
        }

        return listaMantis;

    }

    public static List<Guerrero> crearDepredadores(int numGuerreros) {

        List<Guerrero> listaDepredadores = new CopyOnWriteArrayList<>();

        logger.info("Creando la tripulacion de Depredadores...");

        Depredador depredador;

        for (int i = 0; i < numGuerreros; i++) {

            try {
                depredador = new Depredador("Depredador " + i, "Depredador", 9 - i, 1 + i, "La Fortuna");
                listaDepredadores.add(depredador);
            } catch (TooManyFuerzaResistencia e) {
                e.printStackTrace();
            }

        }

        return listaDepredadores;

    }

}
