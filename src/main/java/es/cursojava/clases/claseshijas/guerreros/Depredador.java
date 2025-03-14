package es.cursojava.clases.claseshijas.guerreros;

import es.cursojava.clases.clasespadres.Guerrero;

public class Depredador extends Guerrero {

    private String planeta;

    // Constructor
    public Depredador(String nombre, String tipo, int fuerza, int resistencia, String planeta) {
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

        double factorFuerzaDepredador = Math.random() * 0.5;
        int sumaFuerzaDepredadot = this.fuerza;

        return (int) (sumaFuerzaDepredadot * factorFuerzaDepredador);
    }

    // SUM (Resistencia de todos los guerreros) * (random 0-0.5)
    @Override
    public int apoyoDefensa() {

        double factorDefensaDepredador = Math.random() * 0.5;
        int sumaResistenciaDepredador = this.resistencia;

        return (int) (sumaResistenciaDepredador * factorDefensaDepredador);
    }

}
