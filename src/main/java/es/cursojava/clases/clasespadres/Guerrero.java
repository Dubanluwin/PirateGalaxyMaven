package es.cursojava.clases.clasespadres;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.batalla.CampoDeBatalla;
import es.cursojava.excepciones.TooManyFuerzaResistencia;

public abstract class Guerrero {
    private static final Logger logger = LoggerFactory.getLogger(Guerrero.class);    
    protected String nombre;
    protected String tipo;
    protected int fuerza;
    protected int resistencia;

    // Constructor
    public Guerrero(String nombre, String tipo, int fuerza, int resistencia) {
        try {
            controlarFuerzaResistencia(fuerza, resistencia);
        } catch (TooManyFuerzaResistencia e) {
            logger.error("Error al crear el Guerrero: " + e.getMessage());
        }
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Método paracontrolar la Fuerza y Resistencia de los Guerreos para que no
    // exceda de un total de 10 p.
    // Este método lo llamaremos desde el constructor.
    private void controlarFuerzaResistencia(int fuerza, int resistencia) throws TooManyFuerzaResistencia {

        if (fuerza + resistencia > 10 || fuerza < 0 || resistencia < 0) {
            this.fuerza = 5;
            this.resistencia = 5;
            logger.info("\n\t Reestableciendo valores por defecto a ..." +
                    "\n Defensa = " + this.resistencia +
                    "\n Ataque = " + this.fuerza);

            // Lanzamos la excepción después de restablecer los valores por defecto
            throw new TooManyFuerzaResistencia("Los valores de ataque y defensa no son validos para este combate.");

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

    // Getters y Setters
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
