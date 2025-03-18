package es.cursojava.clases.claseshijas.vehiculos;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.batalla.CampoDeBatalla;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.clases.clasespadres.VehiculoGuerra;
import es.cursojava.excepciones.TooManyAtaqueDefensa;
import es.cursojava.excepciones.TooManyGuerreros;

public class NaveDepredadora extends VehiculoGuerra {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    public NaveDepredadora(int puntosVida, int ataque, int defensa, String nombre, String tipo,
            List<Guerrero> listaGuerreros, Map<Class<?>, List<Guerrero>> mapaVehiculoGuerra)
            throws TooManyAtaqueDefensa {
        super(puntosVida, ataque, defensa, nombre, tipo, listaGuerreros, mapaVehiculoGuerra);
    }

    @Override
    public void embarcarGuerrero(VehiculoGuerra naveDepredadora, Guerrero guerrero) throws TooManyGuerreros {

        if (!guerrero.getTipo().equalsIgnoreCase("Depredador")) {
            throw new IllegalArgumentException(
                    "Solo los guerreros de tipo Depredador pueden embarcar en la NaveDepredadora.");
        }
        super.embarcarGuerrero(naveDepredadora, guerrero);
    }

    @Override
    public int alcance() {
        return super.alcance();
    }

    // Controlar para que se ejecute al azar
    // VIKTOR: Hecho.
    @Override
    public int atacar() {
        double probabilidad = Math.random();

        if (puntosVida <= 650 && probabilidad < 0.5) {
            ataque -= 2;
            defensa += 4;
        }

        int ataqueTotal = (int) (ataque * Math.random());
        for (Guerrero guerrero : listaGuerreros) {
            ataqueTotal += guerrero.apoyoAtaque();
        }

        return ataqueTotal;
    }

    @Override
    public int defender(int ataqueRecibido) {
        int defensaTotal = (int) (defensa * Math.random());
        for (Guerrero guerrero : listaGuerreros) {
            defensaTotal += guerrero.apoyoDefensa();
        }
        int daño = ataqueRecibido - defensaTotal;
        puntosVida -= Math.max(daño, 0);
        return Math.max(daño, 0);
    }

    @Override
    public String toString() {
        return "NaveDestructora []";
    }

}
