package com.pirategalaxy.clases.claseshijas.guerreros;

import com.pirategalaxy.clases.clasespadres.Guerrero;
import com.pirategalaxy.excepciones.TooManyFuerzaResistencia;

public class Depredador extends Guerrero {

    private String planeta;

    public Depredador(String nombre, String tipo, int fuerza, int resistencia, String planeta) throws TooManyFuerzaResistencia {
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
        // TODO Auto-generated method stub
        return super.apoyoAtaque();
    }

    @Override
    public int apoyoDefensa() {
        // TODO Auto-generated method stub
        return super.apoyoDefensa();
    }

}
