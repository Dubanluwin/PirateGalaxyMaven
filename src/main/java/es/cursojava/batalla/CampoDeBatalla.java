package es.cursojava.batalla;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.claseshijas.guerreros.Depredador;
import es.cursojava.clases.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.excepciones.TooManyAtaqueDefensa;
import es.cursojava.excepciones.TooManyFuerzaResistencia;
import es.cursojava.excepciones.TooManyGuerreros;

public class CampoDeBatalla {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    public static void main(String[] args) throws TooManyFuerzaResistencia {

        try {
            List<Guerrero> mantis = ConfiguracionBatalla.crearMantis(10);
            System.out.println(mantis);

            List<Guerrero> depredadores = ConfiguracionBatalla.crearDepredadores(10);
            System.out.println(depredadores);

            Map<Class<?>, List<Guerrero>> nave = new HashMap<>();
            NaveDepredadora naveDepredadora = new NaveDepredadora(1000, 5, 5, "Mutiladora", "Depredador", depredadores,
                    nave);
        } catch (TooManyAtaqueDefensa | TooManyFuerzaResistencia e) {

            e.printStackTrace();
        }

    }

}
