package es.cursojava.clases.claseshijas.guerreros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.batalla.CampoDeBatalla;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.excepciones.TooManyFuerzaResistencia;

public class Depredador extends Guerrero {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    private String planeta;

    public Depredador(String nombre, String tipo, int fuerza, int resistencia, String planeta)
            throws TooManyFuerzaResistencia {
        super(nombre, tipo, fuerza, resistencia);
        this.planeta = planeta;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    @Override
    public String toString() {

        String mensaje = "\n" + nombre + ", " + tipo + ", fuerza = " + fuerza + ", resistencia = " + resistencia
                + ", planeta = " + planeta;

        return mensaje;
    }

    @Override
    public int apoyoAtaque() {
        // Crear el apoyo de ataque a las naves de los piratas
        return super.apoyoAtaque();
    }

    @Override
    public int apoyoDefensa() {
        // Crear el apoyo de defensa las naves de los piratas
        return super.apoyoDefensa();
    }

}
