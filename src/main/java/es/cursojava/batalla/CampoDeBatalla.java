package es.cursojava.batalla;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.clasespadres.Guerrero;

public class CampoDeBatalla {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    public static void main(String[] args) {

        List<Guerrero> mantis = ConfiguracionBatalla.crearMantis(10);
        System.out.println(mantis);

        List<Guerrero> depredadores = ConfiguracionBatalla.crearDepredadores(10);
        System.out.println(depredadores);

    }

}
