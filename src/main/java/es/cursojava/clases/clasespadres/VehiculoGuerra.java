package es.cursojava.clases.clasespadres;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.claseshijas.guerreros.Depredador;
import es.cursojava.clases.claseshijas.guerreros.Mantis;
import es.cursojava.clases.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.clases.claseshijas.vehiculos.TanqueMantis;
import es.cursojava.excepciones.TooManyAtaqueDefensa;
import es.cursojava.excepciones.TooManyGuerreros;
import es.cursojava.interfaz.Tripulable;

public abstract class VehiculoGuerra implements Tripulable {

    private static final Logger logger = LoggerFactory.getLogger(VehiculoGuerra.class);

    protected int puntosVida = 1000;
    protected int ataque = 5;
    protected int defensa = 5;
    protected String nombre;
    protected String tipo;
    protected List<Guerrero> listaGuerreros = new ArrayList<>();

    public VehiculoGuerra(int puntosVida, int ataque, int defensa, String nombre, String tipo,
            List<Guerrero> listaGuerreros)
            throws TooManyAtaqueDefensa {

        controlarAtaqueDefensa(ataque, defensa);

        this.puntosVida = puntosVida;
        this.nombre = nombre;
        this.tipo = tipo;
        this.listaGuerreros = listaGuerreros;
        // this.listaGuerreros = (listaGuerreros != null) ? listaGuerreros : new ArrayList<>();
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Guerrero> getListaGuerreros() {
        return listaGuerreros;
    }

    public void setListaGuerreros(List<Guerrero> listaGuerreros) {
        this.listaGuerreros = listaGuerreros;
        // this.listaGuerreros = (listaGuerreros != null) ? listaGuerreros : new ArrayList<>();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int atacar() {
        return 0;
    }

    @Override
    public int defender(int danho) {
        return 0;
    }

    @Override
    public int alcance() {

        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "VehiculoGuerra [puntosVida=" + puntosVida + ", ataque=" + ataque + ", defensa=" + defensa + ", nombre="
                + nombre + ", tipo=" + tipo + ", listaGuerreros=" + listaGuerreros + "]";
    }

    protected void controlarAtaqueDefensa(int ataque, int defensa) throws TooManyAtaqueDefensa {
        
        if (ataque < 0 || defensa < 0) {
            throw new TooManyAtaqueDefensa("Los valores de ataque y defensa no pueden ser negativos.");
        }

        if (ataque + defensa > 10) {
            this.ataque = 5;
            this.defensa = 5;
            logger.info("\n Reestableciendo valores por defecto..." +
                    "\n Defensa = " + this.defensa +
                    "\n Ataque = " + this.ataque);

            throw new TooManyAtaqueDefensa("Los valores de ataque y defensa no son válidos para este combate.");
        }

        this.ataque = ataque;
        this.defensa = defensa;
    }

    public void embarcarGuerrero(VehiculoGuerra vehiculo, Guerrero guerrero) throws IllegalArgumentException, TooManyGuerreros {
        final int MAX_GUERREROS = 10;

        if (vehiculo == null || guerrero == null) {
            throw new IllegalArgumentException("El vehículo o guerrero no pueden ser nulos.");
        }

        if (vehiculo instanceof TanqueMantis && !(guerrero instanceof Mantis)) {
            throw new IllegalArgumentException("Solo los guerreros de tipo Mantis pueden embarcar en un Tanque Mantis.");
        }

        if (vehiculo instanceof NaveDepredadora && !(guerrero instanceof Depredador)) {
            throw new IllegalArgumentException("Solo los guerreros de tipo Depredador pueden embarcar en una Nave Depredadora.");
        }

        if (listaGuerreros.size() >= MAX_GUERREROS) {
            throw new TooManyGuerreros("No se pueden embarcar más de " + MAX_GUERREROS + " guerreros en la nave " + tipo);
        }

        listaGuerreros.add(guerrero);
        logger.info("Guerrero de tipo" + guerrero.getTipo() + "embarcado en {}" + tipo);
    }

    public void mostrarGuerreros(List<Guerrero> guerrero) {

        for (Guerrero guerrerox : guerrero) {
            logger.info("Los guerreos son de tipo: " + guerrerox.getTipo() + " y su valores de fuerza: "
                    + guerrerox.getFuerza() + guerrerox.getResistencia());
        }

    }
}
