package es.cursojava.batalla;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import es.cursojava.clases.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.excepciones.TooManyAtaqueDefensa;
import es.cursojava.excepciones.TooManyFuerzaResistencia;
import es.cursojava.excepciones.TooManyGuerreros;
import es.cursojava.excepciones.TooManyHp;

public class CampoDeBatalla {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    public static void main(String[] args) {

        List<Guerrero> depredadores = ConfiguracionBatalla.crearDepredadores();

        try {

            NaveDepredadora nave = new NaveDepredadora(1000, 5, 5, "La Naranja Mecanica", "Depredador");

            try {
                nave.embarcarGuerrero(nave, depredadores);
                try {
                    ConfiguracionBatalla.iniciarBatalla(nave);
                } catch (TooManyFuerzaResistencia e) {
                    e.printStackTrace();
                }
            } catch (TooManyGuerreros e) {
                e.printStackTrace();
            }

        } catch (TooManyAtaqueDefensa e) {
            e.printStackTrace();
        } catch (TooManyHp e) {
            e.printStackTrace();
        }

    }
}
