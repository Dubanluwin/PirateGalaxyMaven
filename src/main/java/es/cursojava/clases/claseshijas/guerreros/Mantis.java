package es.cursojava.clases.claseshijas.guerreros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.batalla.CampoDeBatalla;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.excepciones.TooManyFuerzaResistencia;

public class Mantis extends Guerrero {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    private String planeta;

    // Constructor
    public Mantis(String nombre, String tipo, int fuerza, int resistencia, String planeta)
            throws TooManyFuerzaResistencia {
        super(nombre, tipo, fuerza, resistencia);
        this.planeta = planeta;
    }

    // Getters y Setters
    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    // toString
    @Override
    public String toString() {

        String mensaje = "\n" + nombre + ", " + tipo + ", fuerza = " + fuerza + ", resistencia = " + resistencia
                + ", planeta = " + planeta;

        return mensaje;
    }

    // SUM (fuerza de todos los guerreros) * (random 0-0.5)
    @Override
    public int apoyoAtaque() {

        double factorFuerzaMantis = Math.random() * 0.5;
        int sumaFuerzaMantis = this.fuerza;

        return (int) (sumaFuerzaMantis * factorFuerzaMantis);
    }

    // SUM (Resistencia de todos los guerreros) * (random 0-0.5)
    @Override
    public int apoyoDefensa() {

        double factorDefensaMantis = Math.random() * 0.5;
        int sumaResistenciaMantis = this.resistencia;

        return (int) (sumaResistenciaMantis * factorDefensaMantis);
    }

}
