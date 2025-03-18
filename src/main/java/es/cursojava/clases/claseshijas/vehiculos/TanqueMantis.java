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

public class TanqueMantis extends VehiculoGuerra {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    public TanqueMantis(int puntosVida, int ataque, int defensa, String nombre, String tipo,
            List<Guerrero> listaGuerreros)
            throws TooManyAtaqueDefensa {
        super(puntosVida, ataque, defensa, nombre, tipo, listaGuerreros);
    }

    // Controlar para que se ejecute al azar
    // VIKTOR: Hecho.
    @Override
    public int atacar() {
        double probabilidad = Math.random();

        if (puntosVida <= 500 && probabilidad < 0.5) {
            ataque += 10;
        }

        int ataqueTotal = (int) (ataque * Math.random());
        for (Guerrero guerrero : listaGuerreros) {
            ataqueTotal += guerrero.getFuerza() * Math.random() * 0.5;
        }

        return ataqueTotal;
    }

    @Override
    public int defender(int ataqueRecibido) {

        int defensaTotal = (int) (defensa * Math.random());
        for (Guerrero guerrero : listaGuerreros) {
            defensaTotal += guerrero.getResistencia() * Math.random() * 0.5;
        }

        int daño = ataqueRecibido - defensaTotal;
        puntosVida -= Math.max(daño, 0);
        return Math.max(daño, 0);
    }

    @Override
    public int alcance() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "Tanque []";
    }

    @Override
    public void embarcarGuerrero(VehiculoGuerra tanqueMantis, Guerrero guerrero) throws TooManyGuerreros {
        super.embarcarGuerrero(tanqueMantis, guerrero);
        if (!guerrero.getTipo().equalsIgnoreCase("Mantis")) {
            throw new IllegalArgumentException("Solo los guerreros de tipo Mantis pueden embarcar en la Tanque.");
        }

    }

}
