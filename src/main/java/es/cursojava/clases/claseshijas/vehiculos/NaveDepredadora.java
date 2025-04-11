package es.cursojava.clases.claseshijas.vehiculos;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.clases.clasespadres.VehiculoGuerra;
import es.cursojava.excepciones.TooManyAtaqueDefensa;
import es.cursojava.excepciones.TooManyGuerreros;
import es.cursojava.excepciones.TooManyHp;

public class NaveDepredadora extends VehiculoGuerra {

    private static final Logger logger = LoggerFactory.getLogger(NaveDepredadora.class);
    private boolean estadisticasModificadas = false;

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
    public int alcance() {
        return super.alcance();
    }

    @Override
    public int atacar() {

        int ataqueTotal = (int) (ataque * Math.random());
        for (Guerrero guerrero : listaGuerreros) {
            ataqueTotal += guerrero.getFuerza() * Math.random() * 0.5;
        }

        return ataqueTotal;
    }

    @Override
    public int defender(int ataqueRecibido) {

        for (Guerrero guerrero : listaGuerreros) {
            defensa += guerrero.apoyoDefensa();
        }

        int danho = ataqueRecibido - defensa;
        if (danho > 0) {
            puntosVida -= danho;
        } else {
            logger.info("La nave Depredadora bloqueo el ataque en este turno.");
        }

        int defensaTotal = defensa - danho;

        return defensaTotal;
    }

    @Override
    public String toString() {
        return "NaveDestructora []";
    }

}
