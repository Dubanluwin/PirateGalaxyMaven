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
import es.cursojava.excepciones.TooManyHp;
import es.cursojava.interfaz.Tripulable;

public abstract class VehiculoGuerra implements Tripulable {

    private static final Logger logger = LoggerFactory.getLogger(VehiculoGuerra.class);

    protected int puntosVida;
    protected int ataque;
    protected int defensa;
    protected String nombre;
    protected String tipo;
    protected List<Guerrero> listaGuerreros = new ArrayList<>();

    public VehiculoGuerra(int puntosVida, int ataque, int defensa, String nombre, String tipo)
            throws TooManyAtaqueDefensa, TooManyHp {

        try {
            controlarAtaqueDefensa(ataque, defensa);
            controlarPuntosVida(puntosVida);
            this.nombre = nombre;
            this.tipo = tipo;

        } catch (TooManyAtaqueDefensa e) {
            throw new TooManyAtaqueDefensa(
                    "La suma del ataque y la defensa de los guerreros no puede ser mayor de 10 puntos.");
        } catch (TooManyHp e) {
            throw new TooManyHp("La nave no puede superar los 1000 puntos de vida.");
        }
    }

    private void controlarPuntosVida(int puntosVida) throws TooManyHp {

        if (puntosVida < 0 || puntosVida > 1000) {
            throw new TooManyHp("La nave no puede superar los 1000 puntos de vida.");
        }
        this.puntosVida = puntosVida;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    private void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getAtaque() {
        return ataque;
    }

    private void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    private void setDefensa(int defensa) {
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

    private void setListaGuerreros(List<Guerrero> listaGuerreros) {
        this.listaGuerreros = listaGuerreros;
    }

    public String getTipo() {
        return tipo;
    }

    private void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int atacar() {

        int ataqueTotal = (int) (ataque * Math.random());
        for (Guerrero guerrero : listaGuerreros) {
            ataqueTotal += guerrero.apoyoAtaque();
        }

        return ataqueTotal;
    }

    @Override
    public int defender(int ataqueRecibido) {

        int defensaTotal = (int) (defensa * Math.random());
        for (Guerrero guerrero : listaGuerreros) {
            defensaTotal += guerrero.getResistencia() * Math.random() * 0.5;
        }

        int danio = ataqueRecibido - defensaTotal;
        if (danio > 0) {
            puntosVida -= danio;
        }

        return Math.max(danio, 0);
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

    public void embarcarGuerrero(VehiculoGuerra vehiculo, List<Guerrero> guerreros)
            throws IllegalArgumentException, TooManyGuerreros {
        final int MAX_GUERREROS = 10;

        if (vehiculo == null || guerreros == null) {
            throw new IllegalArgumentException("El vehículo o la lista de guerreros no pueden ser nulos.");
        }

        for (Guerrero guerrero : guerreros) {
            if (vehiculo instanceof TanqueMantis && !(guerrero instanceof Mantis)) {
                throw new IllegalArgumentException(
                        "Solo los guerreros de tipo Mantis pueden embarcar en un Tanque Mantis.");
            }

            if (vehiculo instanceof NaveDepredadora && !(guerrero instanceof Depredador)) {
                throw new IllegalArgumentException(
                        "Solo los guerreros de tipo Depredador pueden embarcar en una Nave Depredadora.");
            }

            if (listaGuerreros.size() >= MAX_GUERREROS) {
                throw new TooManyGuerreros("No se pueden embarcar más de " + MAX_GUERREROS + " guerreros en la nave.");
            }

            listaGuerreros.add(guerrero);
            logger.info(
                    "Guerrero de tipo " + guerrero.getTipo() + " embarcado en " + vehiculo.getClass().getSimpleName());
        }
    }

    public void mostrarGuerreros(List<Guerrero> guerrero) {

        for (Guerrero guerrerox : guerrero) {
            logger.info("Los guerreos son de tipo: " + guerrerox.getTipo() + " y su valores de fuerza: "
                    + guerrerox.getFuerza() + guerrerox.getResistencia());
        }

    }
}
