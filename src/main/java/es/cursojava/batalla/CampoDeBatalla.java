package es.cursojava.batalla;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.claseshijas.guerreros.Depredador;
import es.cursojava.clases.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.clases.clasespadres.VehiculoGuerra;
import es.cursojava.excepciones.TooManyAtaqueDefensa;
import es.cursojava.excepciones.TooManyFuerzaResistencia;
import es.cursojava.excepciones.TooManyGuerreros;
import es.cursojava.excepciones.TooManyHp;

public class CampoDeBatalla {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    public static void main(String[] args) {

        List<Guerrero> depredadores = ConfiguracionBatalla.crearDepredadores();

        try {

            NaveDepredadora nave = new NaveDepredadora(1000, 6, 4, "LOXO", "Depredador");
            try {
                nave.embarcarGuerrero(nave, depredadores);
                try {
                    ConfiguracionBatalla.iniciarBatalla(nave);
                } catch (TooManyFuerzaResistencia e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } catch (TooManyGuerreros e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (TooManyAtaqueDefensa e) {
            e.printStackTrace();
        } catch (TooManyHp e) {
            e.printStackTrace();
        }

    }
}
