package es.cursojava.clases.claseshijas.guerreros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.excepciones.TooManyFuerzaResistencia;

public class Mantis extends Guerrero {

    private static final Logger logger = LoggerFactory.getLogger(Mantis.class);

    private String planeta;

    public Mantis(String nombre, String tipo, int fuerza, int resistencia, String planeta)
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
    public int apoyoAtaque() {

        double factorFuerzaMantis = Math.random() * 0.5;
        int sumaFuerzaMantis = getFuerza();

        return (int) (sumaFuerzaMantis * factorFuerzaMantis);
    }

    @Override
    public int apoyoDefensa() {

        double factorDefensaMantis = Math.random() * 0.5;
        int sumaResistenciaMantis = getResistencia();

        return (int) (sumaResistenciaMantis * factorDefensaMantis);
    }

    @Override
    public String toString() {

        String mensaje = "\n" + getNombre() + ", " + getTipo() + ", fuerza = " + getFuerza() + ", resistencia = "
                + getResistencia()
                + ", planeta = " + planeta;

        return mensaje;
    }

}
