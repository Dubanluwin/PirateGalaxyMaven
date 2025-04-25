package es.cursojava.proyecto.batalla;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.proyecto.clases.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.proyecto.clases.clasespadres.Guerrero;
import es.cursojava.proyecto.excepciones.TooManyAtaqueDefensa;
import es.cursojava.proyecto.excepciones.TooManyFuerzaResistencia;
import es.cursojava.proyecto.excepciones.TooManyGuerreros;
import es.cursojava.proyecto.excepciones.TooManyHp;

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
