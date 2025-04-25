package es.cursojava.proyecto.batalla;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.proyecto.clases.claseshijas.guerreros.Depredador;
import es.cursojava.proyecto.clases.claseshijas.guerreros.Mantis;
import es.cursojava.proyecto.clases.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.proyecto.clases.claseshijas.vehiculos.TanqueMantis;
import es.cursojava.proyecto.clases.clasespadres.Guerrero;
import es.cursojava.proyecto.clases.clasespadres.VehiculoGuerra;
import es.cursojava.proyecto.excepciones.TooManyAtaqueDefensa;
import es.cursojava.proyecto.excepciones.TooManyFuerzaResistencia;
import es.cursojava.proyecto.excepciones.TooManyGuerreros;
import es.cursojava.proyecto.excepciones.TooManyHp;

public class ConfiguracionBatalla {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

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

            NaveDepredadora naveDepredadora = new NaveDepredadora(1000, 8, 2, "La Cazadora", "Depredador");
            TanqueMantis tanqueMantis = new TanqueMantis(1000, 4, 6, "La Destructora", "Mantis");

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

                // Determina quién tiene mayor alcance 1:
        // VehiculoGuerra atacante = (alcanceNave >= alcanceTanque) ? naveDepredadora :
        // tanqueMantis;
        // if (alcanceNaveEnemiga > atacante.alcance()) {
        // logger.info("La nave enemiga tiene mayor alcance y ataca primero.");
        // ConfiguracionBatalla.iniciarBatalla(naveEnemiga, atacante);
        // } else {
        // logger.info(atacante.getNombre() + " tiene mayor alcance y ataca primero.");
        // ConfiguracionBatalla.iniciarBatalla(atacante, naveEnemiga);
        // }

        // Método alcance definido

        VehiculoGuerra combatiente;
        if (naveDepredadora.alcance() >= tanqueMantis.alcance()) {
            combatiente = naveDepredadora;
        } else {
            combatiente = tanqueMantis;
        }
        logger.info(combatiente.getNombre() + " ha sido seleccionado para la batalla.");

        return combatiente;
    }

    // VIK: añadido nuevo método para mostrar la barra de vida.
    private static String barraVida(int puntosVida) {
        final int VIDA_MAXIMA = 1000;
        final int LONGITUD_BARRA = 20;
    
        int bloques = Math.max(0, Math.min(LONGITUD_BARRA, puntosVida / (VIDA_MAXIMA / LONGITUD_BARRA)));
        int vacios = LONGITUD_BARRA - bloques;
    
        StringBuilder barra = new StringBuilder("[");
        for (int i = 0; i < bloques; i++) {
            barra.append("#"); // Vida restante
        }
        for (int i = 0; i < vacios; i++) {
            barra.append("-"); // Vida perdida
        }
        barra.append("] ");
    
        int porcentaje = (int) ((puntosVida / (double) VIDA_MAXIMA) * 100);
        barra.append(puntosVida).append(" PV (").append(porcentaje).append("%)");
    
        return barra.toString();
    }

    // private static void ataqueDeNave(VehiculoGuerra combatiente, VehiculoGuerra vehiculoProfe) {
    //     int ataqueNave = combatiente.atacar();
    //     int danioRecibidoTanque = vehiculoProfe.defender(ataqueNave);
    //     logger.info(combatiente.getNombre() + " ataca con " + ataqueNave + " de danio. | " + vehiculoProfe.getNombre()
    //             + " recibe " + danioRecibidoTanque + " de danio.");

    //     if (vehiculoProfe.getPuntosVida() <= 0) {
    //         logger.info(vehiculoProfe.getNombre() + " ha sido destruido - " + combatiente.getNombre()
    //                 + " gana la batalla!");
    //     }
    // }

    // VIK: He cambiado el método ataqueDeNave para que imprima el resultado de la batalla.
    private static void ataqueDeNave(VehiculoGuerra combatiente, VehiculoGuerra vehiculoProfe) {
        int ataque = combatiente.atacar();
        vehiculoProfe.defender(ataque);
    
        logger.info(">>> " + combatiente.getNombre() + " ataca con " + ataque + " de daño.");
        logger.info(">>> " + vehiculoProfe.getNombre() + " se defiende con " + vehiculoProfe.getUltimaDefensa() + ".");
        logger.info(">>> " + vehiculoProfe.getNombre() + " recibe " + vehiculoProfe.getUltimoDanioRecibido() + " de daño.");
        logger.info(">>> PV restante de " + vehiculoProfe.getNombre() + ": " + barraVida(vehiculoProfe.getPuntosVida()));
    
        if (vehiculoProfe.getPuntosVida() <= 0) {
            logger.info(vehiculoProfe.getNombre() + " ha sido destruido. " + combatiente.getNombre() + " gana la batalla!");
        }
    }
    
    // private static void ataqueDeTanque(VehiculoGuerra vehiculoProfe, VehiculoGuerra combatiente) {
    //     int ataqueTanque = vehiculoProfe.atacar();
    //     int danioRecibidoNave = combatiente.defender(ataqueTanque);
    //     logger.info(vehiculoProfe.getNombre() + " ataca con " + ataqueTanque + " de danio. | " + combatiente.getNombre()
    //             + " recibe " + danioRecibidoNave + " de danio.");

    //     if (combatiente.getPuntosVida() <= 0) {
    //         logger.info(combatiente.getNombre() + " ha sido destruido. - " + vehiculoProfe.getNombre()
    //                 + " gana la batalla!");
    //     }
    // }

    // VIK: He cambiado el método ataqueDeTanque para que imprima el resultado de la batalla.
    private static void ataqueDeTanque(VehiculoGuerra vehiculoProfe, VehiculoGuerra combatiente) {
        int ataque = vehiculoProfe.atacar();
        combatiente.defender(ataque);
    
        logger.info(">>> " + vehiculoProfe.getNombre() + " ataca con " + ataque + " de daño.");
        logger.info(">>> " + combatiente.getNombre() + " se defiende con " + combatiente.getUltimaDefensa() + ".");
        logger.info(">>> " + combatiente.getNombre() + " recibe " + combatiente.getUltimoDanioRecibido() + " de daño.");
        logger.info(">>> PV restante de " + combatiente.getNombre() + ": " + barraVida(combatiente.getPuntosVida()));
    
        if (combatiente.getPuntosVida() <= 0) {
            logger.info(combatiente.getNombre() + " ha sido destruido." + vehiculoProfe.getNombre() + " gana la batalla!");
        }
    }    
    
}
