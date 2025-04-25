package es.cursojava.proyecto.clases.claseshijas.guerreros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.proyecto.clases.clasespadres.Guerrero;
import es.cursojava.proyecto.excepciones.TooManyFuerzaResistencia;

public class Depredador extends Guerrero {

    private static final Logger logger = LoggerFactory.getLogger(Depredador.class);

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
    public int apoyoAtaque() {

        double factorFuerzaDepredador = Math.random() * 0.5;
        int sumaFuerzaDepredador = getFuerza();

        return (int) (sumaFuerzaDepredador * factorFuerzaDepredador);
    }

    @Override
    public int apoyoDefensa() {

        double factorDefensaDepredador = Math.random() * 0.5;
        int sumaResistenciaDepredador = getResistencia();

        return (int) (sumaResistenciaDepredador * factorDefensaDepredador);
    }

    @Override
    public String toString() {

        String mensaje = "\n" + getNombre() + ", " + getTipo() + ", fuerza = " + getFuerza() + ", resistencia = " + getResistencia()
                + ", planeta = " + planeta;

        return mensaje;
    }

}
