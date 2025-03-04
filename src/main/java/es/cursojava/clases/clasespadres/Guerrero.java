package com.pirategalaxy.clases.clasespadres;

import com.pirategalaxy.excepciones.TooManyFuerzaResistencia;

public abstract class Guerrero {

    protected String nombre;
    protected String tipo;
    protected int fuerza;
    protected int resistencia;

    // Añadir excepción  La suma de la fuerza y la resistencia de un guerrero no
    // puede ser mayor de 10
    
    public Guerrero(String nombre, String tipo, int fuerza, int resistencia) throws TooManyFuerzaResistencia {
        controlarFuerzaResistencia(fuerza, resistencia);
        this.nombre = nombre;
        this.tipo = tipo;
    }

    private void controlarFuerzaResistencia(int fuerza, int resistencia) throws TooManyFuerzaResistencia {
        if (fuerza + resistencia > 10 || fuerza < 0 || resistencia < 0) {
            this.fuerza = 5;
            this.resistencia = 5;
            System.out.println("\n Reestableciendo valores por defecto..." +
                    "\n Defensa = " + this.resistencia +
                    "\n Ataque = " + this.fuerza);

            // Lanzamos la excepción después de restablecer los valores por defecto
            throw new TooManyFuerzaResistencia("Los valores de ataque y defensa no son válidos para este combate.");
            
        } else {
            this.fuerza = fuerza;
            this.resistencia = resistencia;
        }
    }

    // Cada guerrero aporta puntos extra de ataque al vehículo.

    public int apoyoAtaque() {

        return fuerza;
    }

    // Cada guerrero aporta puntos extra de defensa al vehículo.
    public int apoyoDefensa() {

        return resistencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

}
