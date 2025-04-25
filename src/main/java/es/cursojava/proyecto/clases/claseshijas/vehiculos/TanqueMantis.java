package es.cursojava.proyecto.clases.claseshijas.vehiculos;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.proyecto.clases.clasespadres.Guerrero;
import es.cursojava.proyecto.clases.clasespadres.VehiculoGuerra;
import es.cursojava.proyecto.excepciones.TooManyAtaqueDefensa;
import es.cursojava.proyecto.excepciones.TooManyGuerreros;
import es.cursojava.proyecto.excepciones.TooManyHp;

public class TanqueMantis extends VehiculoGuerra {

    private static final Logger logger = LoggerFactory.getLogger(TanqueMantis.class);

    public TanqueMantis(int puntosVida, int ataque, int defensa, String nombre, String tipo)
            throws TooManyAtaqueDefensa, TooManyHp {
        super(puntosVida, ataque, defensa, nombre, tipo);
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

    @Override
    public int atacar() {
        return super.atacar();
    }

    @Override
    public int defender(int ataqueEntrante) {
        return super.defender(ataqueEntrante);
    }

    @Override
    public int alcance() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "Tanque Mantis []";
    }

}
