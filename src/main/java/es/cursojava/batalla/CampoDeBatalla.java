package es.cursojava.batalla;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.clases.claseshijas.vehiculos.TanqueMantis;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.clases.clasespadres.VehiculoGuerra;
import es.cursojava.excepciones.TooManyAtaqueDefensa;
import es.cursojava.excepciones.TooManyGuerreros;

public class CampoDeBatalla {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    public static void main(String[] args) {

        // try {
        //     List<Guerrero> mantis = ConfiguracionBatalla.crearMantis(10);
        //     List<Guerrero> depredadores = ConfiguracionBatalla.crearDepredadores(10);

        //     NaveDepredadora naveDepredadora = new NaveDepredadora(1000, 5, 5, "Mutiladora", "Depredador");
        //     TanqueMantis tanqueMantis = new TanqueMantis(1000, 5, 5, "Aniquiladora", "Mantis");

        //     logger.info("Guerreros en la Nave Depredadora antes de embarcar: "
        //             + naveDepredadora.getListaGuerreros().size());
        //     naveDepredadora.embarcarGuerrero(naveDepredadora, depredadores);
        //     logger.info("Guerreros en la Nave Depredadora despues de embarcar: "
        //             + naveDepredadora.getListaGuerreros().size());

        //     logger.info("Guerreros en el Tanque Mantis antes de embarcar: " + tanqueMantis.getListaGuerreros().size());
        //     tanqueMantis.embarcarGuerrero(tanqueMantis, mantis);
        //     logger.info(
        //             "Guerreros en el Tanque Mantis despues de embarcar: " + tanqueMantis.getListaGuerreros().size());

        //     ConfiguracionBatalla.iniciarBatalla(naveDepredadora, tanqueMantis);

        // } catch (TooManyAtaqueDefensa e) {
        //     logger.error("Error al crear los vehiculos de guerra: " + e.getMessage());
        // } catch (TooManyGuerreros e) {
        //     logger.error("La embarcacion de los guerreros no puede superar la cantidad de 10 candidatos.");
        // }


        // =============== VIKTOR: Nuevo código ===============
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

            int alcanceNave = naveDepredadora.alcance();
            int alcanceTanque = tanqueMantis.alcance();
            
            logger.info("Alcance de " + naveDepredadora.getNombre() + ": " + alcanceNave);
            logger.info("Alcance de " + tanqueMantis.getNombre() + ": " + alcanceTanque);


            // ===== VIKTOR: tenemos que ver como importar la nace del profe =====

            // Importar nave enemiga desde otro código (simulado aquí como un objeto externo)
            // Esta parte de código es sólo de prueba.
            NaveDepredadora naveEnemiga = new NaveDepredadora(1000, 5, 5, "Destructor Espacial", "Humano");
            int alcanceNaveEnemiga = naveEnemiga.alcance();
            logger.info("Alcance de la nave enemiga " + naveEnemiga.getNombre() + ": " + alcanceNaveEnemiga);

            // Importar nave enemiga desde otro código.
            // Este código deberia de ser el que importe la nave del profe.
            VehiculoGuerra naveEnemiga = ImportadorNave.importarNave();
            if (naveEnemiga == null) {
                logger.error("No se pudo importar la nave enemiga.");
                return;
            }
            int alcanceNaveEnemiga = naveEnemiga.alcance();
            logger.info("Alcance de la nave enemiga " + naveEnemiga.getNombre() + ": " + alcanceNaveEnemiga);


            // ===== VIKTOR: He puesto 2 maneras para determinar la nave con mayor alcance, luego elegimos una de las 2 =====

            // Determina quién tiene mayor alcance 1:
            VehiculoGuerra atacante = (alcanceNave >= alcanceTanque) ? naveDepredadora : tanqueMantis;
            if (alcanceNaveEnemiga > atacante.alcance()) {
                logger.info("La nave enemiga tiene mayor alcance y ataca primero.");
                ConfiguracionBatalla.iniciarBatalla(naveEnemiga, atacante);
            } else {
                logger.info(atacante.getNombre() + " tiene mayor alcance y ataca primero.");
                ConfiguracionBatalla.iniciarBatalla(atacante, naveEnemiga);
            }

            // Determina quién tiene mayor alcance 2:
            VehiculoGuerra combatiente;
            if (naveDepredadora.alcance() >= tanqueMantis.alcance()) {
                combatiente = naveDepredadora;
            } else {
                combatiente = tanqueMantis;
            }
            logger.info(combatiente.getNombre() + " ha sido seleccionado para la batalla.");            

            // Iniciar batalla entre naves:
            logger.info("Iniciando batalla entre " + combatiente.getNombre() + " y " + naveEnemiga.getNombre());
            ConfiguracionBatalla.iniciarBatalla(combatiente, naveEnemiga);

            // VIKTOR: Si ves que nos da fallos en "iniciarBatalla" es porque no tenemos metida
            // la "naveEnemiga" en el propio método. Tendrías que encontrar la manera de meter la
            // "naveEnemiga" (nave del profe) en el método sin que nos de fallo.

        } catch (TooManyAtaqueDefensa e) {
            logger.error("Error al crear los vehículos de guerra: " + e.getMessage());
        } catch (TooManyGuerreros e) {
            logger.error("La embarcación de los guerreros no puede superar la cantidad de 10 candidatos.");
        }
    }
}