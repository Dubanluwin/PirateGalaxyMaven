package es.cursojava.hibernate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.hibernate.entity.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.hibernate.entity.clasespadres.Guerrero;
import es.cursojava.hibernate.exception.TooManyAtaqueDefensa;
import es.cursojava.hibernate.exception.TooManyFuerzaResistencia;
import es.cursojava.hibernate.exception.TooManyGuerreros;
import es.cursojava.hibernate.exception.TooManyHp;

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
