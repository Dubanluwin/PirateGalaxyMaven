package es.cursojava.batalla;

import java.util.List;

import es.cursojava.clases.clasespadres.Guerrero;



public class CampoDeBatalla {

    public static void main(String[] args) {

        List<Guerrero> mantis = ConfiguracionBatalla.crearMantis(10);
        System.out.println(mantis);

        List<Guerrero> depredadores = ConfiguracionBatalla.crearDepredadores(10);
        System.out.println(depredadores);

        
    }

}
