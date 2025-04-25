package es.cursojava.proyecto.clases.claseshijas.vehiculos;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.proyecto.clases.clasespadres.Guerrero;
import es.cursojava.proyecto.clases.clasespadres.VehiculoGuerra;
import es.cursojava.proyecto.excepciones.TooManyAtaqueDefensa;
import es.cursojava.proyecto.excepciones.TooManyGuerreros;
import es.cursojava.proyecto.excepciones.TooManyHp;

public class NaveDepredadora extends VehiculoGuerra {

    private static final Logger logger = LoggerFactory.getLogger(NaveDepredadora.class);

    public NaveDepredadora(int puntosVida, int ataque, int defensa, String nombre, String tipo)
            throws TooManyAtaqueDefensa, TooManyHp {
        super(puntosVida, ataque, defensa, nombre, tipo);
        
    }

    @Override
    public void embarcarGuerrero(VehiculoGuerra naveDepredadora, List<Guerrero> guerreros) throws TooManyGuerreros {
        try {
            for (Guerrero guerrero : guerreros) {
                if (!guerrero.getTipo().equalsIgnoreCase("Depredador")) {
                    throw new IllegalArgumentException(
                            "Solo los guerreros de tipo Depredador pueden embarcar en la NaveDepredadora.");
                }
            }
            super.embarcarGuerrero(naveDepredadora, guerreros);
        } catch (TooManyGuerreros e) {
            throw new TooManyGuerreros("No se pueden embarcar mas de 10 guerreros por vehiculo.");
        }
    }

    @Override
    public int atacar() {
        return super.atacar();
    }

    @Override
    public int defender(int ataqueRecibido) {
        return super.defender(ataqueRecibido);
    }

    @Override
    public int alcance() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "NaveDestructora []";
    }

}
