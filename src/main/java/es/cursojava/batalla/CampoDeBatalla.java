package es.cursojava.batalla;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.clases.claseshijas.vehiculos.TanqueMantis;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.excepciones.TooManyAtaqueDefensa;

public class CampoDeBatalla {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    public static void main(String[] args) {

        try {
            List<Guerrero> mantis = ConfiguracionBatalla.crearMantis(10);
            List<Guerrero> depredadores = ConfiguracionBatalla.crearDepredadores(10);

            NaveDepredadora naveDepredadora = new NaveDepredadora(1000, 5, 5, "Mutiladora", "Depredador", depredadores);
            TanqueMantis tanqueMantis = new TanqueMantis(1000, 5, 5, "Aniquiladora", "Mantis", mantis);
            
            naveDepredadora.embarcarGuerrero(naveDepredadora, depredadores);
            tanqueMantis.embarcarGuerrero(tanqueMantis, mantis);
            
            iniciarBatalla(naveDepredadora, tanqueMantis);

        } catch (TooManyAtaqueDefensa e){
            logger.error("Error al crear los vehículos de guerra: " + e.getMessage());
        } catch (TooManyGuerreros e ) {
            logger.error("La embarcacion de los guerreros no puede superar la cantidad de 10 candidatos.");
        }
    }

    private static void iniciarBatalla(NaveDepredadora nave, TanqueMantis tanque) {
        logger.info("¡Comienza la batalla entre " + nave.getNombre() +" y " + tanque.getNombre() + "!");

        int turno = 1;
        while (nave.getPuntosVida() > 0 && tanque.getPuntosVida() > 0) {
            System.out.println("\nTurno " + turno);
            
            // Ataque de la nave al tanque
            int ataqueNave = nave.atacar();
            int dañoRecibidoTanque = tanque.defender(ataqueNave);
            logger.info(nave.getNombre() + " ataca con " + ataqueNave +" de danio. | " + tanque.getNombre() + " recibe " + dañoRecibidoTanque +" de danio.");

            if (tanque.getPuntosVida() <= 0) {
                logger.info(tanque.getNombre() + " ha sido destruido." + nave.getNombre() + " gana la batalla!");
                break;
            }

            // Ataque del tanque a la nave
            int ataqueTanque = tanque.atacar();
            int dañoRecibidoNave = nave.defender(ataqueTanque);
            logger.info(tanque.getNombre() + " ataca con " + ataqueTanque + " de danio. | " + nave.getNombre() + " recibe " + dañoRecibidoNave + " de danio.");

            if (nave.getPuntosVida() <= 0) {
                logger.info(nave.getNombre() + " ha sido destruido. | " + tanque.getNombre() + " gana la batalla!");
                break;
            }

            turno++;
        }

        logger.info("Fin de la batalla!");
    }

}