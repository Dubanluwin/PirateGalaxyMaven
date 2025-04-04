package es.cursojava.clases.claseshijas.vehiculos;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.clases.clasespadres.VehiculoGuerra;
import es.cursojava.excepciones.TooManyAtaqueDefensa;
import es.cursojava.excepciones.TooManyGuerreros;

public class NaveDepredadora extends VehiculoGuerra {

    private static final Logger logger = LoggerFactory.getLogger(NaveDepredadora.class);
    private boolean estadisticasModificadas = false;

    public NaveDepredadora(int puntosVida, int ataque, int defensa, String nombre, String tipo,
            List<Guerrero> listaGuerreros)
            throws TooManyAtaqueDefensa {
        super(puntosVida, ataque, defensa, nombre, tipo, listaGuerreros);
    }

    public NaveDepredadora(int puntosVida, int ataque, int defensa, String nombre, String tipo) throws TooManyAtaqueDefensa {
        super(puntosVida, ataque, defensa, nombre, tipo);
    }

    @Override
    public void embarcarGuerrero(VehiculoGuerra naveDepredadora, List<Guerrero> guerreros) throws TooManyGuerreros {
        for (Guerrero guerrero : guerreros) {
            if (!guerrero.getTipo().equalsIgnoreCase("Depredador")) {
                throw new IllegalArgumentException("Solo los guerreros de tipo Depredador pueden embarcar en la NaveDepredadora.");
            }
        }
        super.embarcarGuerrero(naveDepredadora, guerreros);
    }

    @Override
    public int alcance() {
        return super.alcance();
    }

    @Override
    public int atacar() {
        double probabilidad = Math.random();

        // Solo modificamos las estadísticas una vez
        if (!estadisticasModificadas && puntosVida <= 650 && probabilidad < 0.5) {
            ataque -= 2;
            defensa += 4;
            estadisticasModificadas = true; 
            // Marcamos que ya se realizó el ajuste. Así nos aseguraremos de que sólo se modifica una vez por batalla.
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

        int danio = ataqueRecibido - defensaTotal;
        if (danio > 0) {
            puntosVida -= danio;
        }

        return Math.max(danio, 0);
    }

    @Override
    public String toString() {
        return "NaveDestructora []";
    }

}
