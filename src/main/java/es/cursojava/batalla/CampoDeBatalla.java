package com.pirategalaxy.batalla;

import java.util.ArrayList;
import java.util.List;

import com.pirategalaxy.clases.claseshijas.guerreros.Mantis;
import com.pirategalaxy.clases.claseshijas.vehiculos.NaveDepredadora;
import com.pirategalaxy.clases.claseshijas.vehiculos.TanqueMantis;
import com.pirategalaxy.clases.clasespadres.Guerrero;

public class CampoDeBatalla {

    public static void main(String[] args) {

        List<Guerrero> mantis = ConfiguracionBatalla.crearMantis(10);
        System.out.println(mantis);

        List<Guerrero> depredadores = ConfiguracionBatalla.crearDepredadores(10);
        System.out.println(depredadores);

        
    }

}
