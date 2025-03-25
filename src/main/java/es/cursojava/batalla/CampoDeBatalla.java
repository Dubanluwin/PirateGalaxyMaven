package es.cursojava.batalla;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.clases.claseshijas.vehiculos.TanqueMantis;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.excepciones.TooManyAtaqueDefensa;
import es.cursojava.excepciones.TooManyGuerreros;

public class CampoDeBatalla {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    public static void main(String[] args) {

        try {
            List<Guerrero> mantis = ConfiguracionBatalla.crearMantis(10);
            List<Guerrero> depredadores = ConfiguracionBatalla.crearDepredadores(10);

            NaveDepredadora naveDepredadora = new NaveDepredadora(1000, 5, 5, "Mutiladora", "Depredador");
            TanqueMantis tanqueMantis = new TanqueMantis(1000, 5, 5, "Aniquiladora", "Mantis");

            logger.info("Guerreros en la Nave Depredadora antes de embarcar: "
                    + naveDepredadora.getListaGuerreros().size());
            naveDepredadora.embarcarGuerrero(naveDepredadora, depredadores);
            logger.info("Guerreros en la Nave Depredadora despues de embarcar: "
                    + naveDepredadora.getListaGuerreros().size());

            logger.info("Guerreros en el Tanque Mantis antes de embarcar: " + tanqueMantis.getListaGuerreros().size());
            tanqueMantis.embarcarGuerrero(tanqueMantis, mantis);
            logger.info(
                    "Guerreros en el Tanque Mantis despues de embarcar: " + tanqueMantis.getListaGuerreros().size());

            ConfiguracionBatalla.iniciarBatalla(naveDepredadora, tanqueMantis);

        } catch (TooManyAtaqueDefensa e) {
            logger.error("Error al crear los vehiculos de guerra: " + e.getMessage());
        } catch (TooManyGuerreros e) {
            logger.error("La embarcacion de los guerreros no puede superar la cantidad de 10 candidatos.");
        }
    }
}