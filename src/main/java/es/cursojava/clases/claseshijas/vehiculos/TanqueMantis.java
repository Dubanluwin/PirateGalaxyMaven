package es.cursojava.clases.claseshijas.vehiculos;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.clases.clasespadres.VehiculoGuerra;
import es.cursojava.excepciones.TooManyAtaqueDefensa;
import es.cursojava.excepciones.TooManyGuerreros;

public class TanqueMantis extends VehiculoGuerra {

    private static final Logger logger = LoggerFactory.getLogger(TanqueMantis.class);
    private boolean ataqueModificado = false;

    public TanqueMantis(int puntosVida, int ataque, int defensa, String nombre, String tipo,
            List<Guerrero> listaGuerreros)
            throws TooManyAtaqueDefensa {
        super(puntosVida, ataque, defensa, nombre, tipo, listaGuerreros);
    }

    public TanqueMantis(int puntosVida, int ataque, int defensa, String nombre, String tipo) {
        super(puntosVida, ataque, defensa, nombre, tipo);
    }

    @Override
    public int atacar() {
        double probabilidad = Math.random();

        if (!ataqueModificado && puntosVida <= 500 && probabilidad < 0.5) {
            ataque += 10;
            ataqueModificado = true;
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
        if (daño > 0) {
            puntosVida -= daño;
        }

        return Math.max(daño, 0);
    }

    @Override
    public int alcance() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "Tanque Mantis []";
    }

    @Override
    public void embarcarGuerrero(VehiculoGuerra tanqueMantis, List<Guerrero> guerreros) throws TooManyGuerreros {
        for (Guerrero guerrero : guerreros) {
            if (!guerrero.getTipo().equalsIgnoreCase("Mantis")) {
                throw new IllegalArgumentException("Solo los guerreros de tipo Mantis pueden embarcar en el Tanque.");
            }
        }
        super.embarcarGuerrero(tanqueMantis, guerreros);
    }

}
