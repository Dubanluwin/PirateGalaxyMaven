package es.cursojava.batalla;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.claseshijas.guerreros.Depredador;
import es.cursojava.clases.claseshijas.guerreros.Mantis;
import es.cursojava.clases.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.clases.claseshijas.vehiculos.TanqueMantis;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.clases.clasespadres.VehiculoGuerra;
import es.cursojava.excepciones.TooManyAtaqueDefensa;
import es.cursojava.excepciones.TooManyFuerzaResistencia;
import es.cursojava.excepciones.TooManyGuerreros;
import es.cursojava.excepciones.TooManyHp;

public class ConfiguracionBatalla {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    private static final int maxDefensa = 10;
    private static final int maxAtaque = 10;
    private static final int maxGuerreros = 10;
    private static final int maxHp = 1000;

    public static List<Guerrero> crearMantis() throws TooManyFuerzaResistencia, TooManyGuerreros {

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
            throw new TooManyFuerzaResistencia(
                    "La suma de la fuerza y la resistencia de cada guerrero Mantis no puede superar 10 puntos.");
        }

        return listaMantis;

    }

    public static List<Guerrero> crearDepredadores() {

        List<Guerrero> listaDepredadores = new CopyOnWriteArrayList<>();

        logger.info("Creando la tripulacion de Depredadores...");

        Depredador depredador;

        for (int i = 0; i < 10; i++) {

            try {
                depredador = new Depredador("Depredador " + i, "Depredador", 9 - i, 1 + i, "La Fortuna");
                listaDepredadores.add(depredador);
            } catch (TooManyFuerzaResistencia e) {
                logger.info(
                        "La suma de la fuerza y la resistencia de cada guerrero Mantis no puede superar 10 puntos.");
            }

        }

        return listaDepredadores;

    }

    public static void iniciarBatalla(VehiculoGuerra vehiculoProfe) throws TooManyHp, TooManyFuerzaResistencia {

        try {
            List<Guerrero> mantis = ConfiguracionBatalla.crearMantis();
            List<Guerrero> depredadores = ConfiguracionBatalla.crearDepredadores();

            NaveDepredadora naveDepredadora = new NaveDepredadora(100000, 5555, 5, "Mutiladora", "Depredador");
            TanqueMantis tanqueMantis = new TanqueMantis(100000, 5, 5000, "Aniquiladora", "Mantis");

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

            VehiculoGuerra combatiente = preparacionBatalla(naveDepredadora, tanqueMantis);

            logger.info(
                    "Comienza la batalla entre " + combatiente.getNombre() + " y " + vehiculoProfe.getNombre() + "!");

            boolean primerAtaque;
            if (combatiente.alcance() >= vehiculoProfe.alcance()) {
                primerAtaque = true;
                logger.info(combatiente.getNombre() + " inicia la batalla debido a su mayor alcance.");
            } else {
                primerAtaque = false;
                logger.info(vehiculoProfe.getNombre() + " inicia la batalla debido a su mayor alcance.");
            }

            int turno = 1;
            while (combatiente.getPuntosVida() > 0 && vehiculoProfe.getPuntosVida() > 0) {
                System.out.println("\nTurno " + turno);

                if (primerAtaque) {
                    ataqueDeNave(combatiente, vehiculoProfe);
                    if (vehiculoProfe.getPuntosVida() <= 0)
                        break;

                    ataqueDeTanque(vehiculoProfe, combatiente);
                    if (combatiente.getPuntosVida() <= 0)
                        break;
                } else {
                    ataqueDeTanque(vehiculoProfe, combatiente);
                    if (combatiente.getPuntosVida() <= 0)
                        break;

                    ataqueDeNave(combatiente, vehiculoProfe);
                    if (vehiculoProfe.getPuntosVida() <= 0)
                        break;
                }

                turno++;
            }

            logger.info("Fin de la batalla!");

        } catch (TooManyAtaqueDefensa e) {
            logger.error("Error al crear los vehículos de guerra: ");
        } catch (TooManyGuerreros e) {
            logger.error("La embarcación de los guerreros no puede superar la cantidad de 10 guerreros.");
        }
    }

    private static VehiculoGuerra preparacionBatalla(VehiculoGuerra tanqueMantis, VehiculoGuerra naveDepredadora) {

        VehiculoGuerra combatiente;
        if (naveDepredadora.alcance() >= tanqueMantis.alcance()) {
            combatiente = naveDepredadora;
        } else {
            combatiente = tanqueMantis;
        }
        logger.info(combatiente.getNombre() + " ha sido seleccionado para la batalla.");

        return combatiente;
    }

    private static void ataqueDeNave(VehiculoGuerra combatiente, VehiculoGuerra vehiculoProfe) {
        int ataqueNave = combatiente.atacar();
        int danioRecibidoTanque = vehiculoProfe.defender(ataqueNave);
        logger.info(combatiente.getNombre() + " ataca con " + ataqueNave + " de danio. | " + vehiculoProfe.getNombre()
                + " recibe " + danioRecibidoTanque + " de danio.");

        if (vehiculoProfe.getPuntosVida() <= 0) {
            logger.info(vehiculoProfe.getNombre() + " ha sido destruido - " + combatiente.getNombre()
                    + " gana la batalla!");
        }
    }

    private static void ataqueDeTanque(VehiculoGuerra vehiculoProfe, VehiculoGuerra combatiente) {
        int ataqueTanque = vehiculoProfe.atacar();
        int danioRecibidoNave = combatiente.defender(ataqueTanque);
        logger.info(vehiculoProfe.getNombre() + " ataca con " + ataqueTanque + " de danio. | " + combatiente.getNombre()
                + " recibe " + danioRecibidoNave + " de danio.");

        if (combatiente.getPuntosVida() <= 0) {
            logger.info(combatiente.getNombre() + " ha sido destruido. - " + vehiculoProfe.getNombre()
                    + " gana la batalla!");
        }
    }
}
