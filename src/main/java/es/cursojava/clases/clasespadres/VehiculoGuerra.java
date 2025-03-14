package es.cursojava.clases.clasespadres;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    // protected Map<String, List<Guerrero>> mapaVehiculoGuerra = new HashMap<>();
    protected Map<Class<?>, List<Guerrero>> mapaVehiculoGuerra = new HashMap<>();

    // Constructor
    public VehiculoGuerra(int puntosVida, int ataque, int defensa, String nombre, String tipo,
            List<Guerrero> listaGuerreros, Map<Class<?>, List<Guerrero>> mapaVehiculoGuerra) {
        try {
            controlarAtaqueDefensa(ataque, defensa);
        } catch (TooManyAtaqueDefensa e) {
            logger.error("Error al crear el Vehículo de Guerra: " + e.getMessage());
        }

        this.puntosVida = puntosVida;
        this.nombre = nombre;
        this.tipo = tipo;
        this.listaGuerreros = listaGuerreros;
        this.mapaVehiculoGuerra = mapaVehiculoGuerra;
    }

    // Método para controlar el Ataque y la Defensa del VehiculoGuerra para que el
    // total no exceda de 10 p.
    // Este método lo llamaremos desde el constructor.
    protected void controlarAtaqueDefensa(int ataque, int defensa) throws TooManyAtaqueDefensa {
        // (ataque + defensa <= 10 ) - Método para crear la excepción de que la suma y
        // el ataque no sea mayor de 10.

        if (ataque + defensa > 10 || ataque < 0 || defensa < 0) {
            this.ataque = 5;
            this.defensa = 5;
            logger.info("\n Reestableciendo valores por defecto..." +
                    "\n Defensa = " + this.defensa +
                    "\n Ataque = " + this.ataque);

            // Lanzamos la excepción después de restablecer los valores por defecto
            throw new TooManyAtaqueDefensa("Los valores de ataque y defensa no son válidos para este combate.");

        } else {
            this.ataque = ataque;
            this.defensa = defensa;
        }
    }

    // Crear un mapa, donde 1 clave sera la nave depredadora con su lista de
    // depredadores, 1 clave sera el tanquis con su lista de guerreros.
    public void embarcar(Guerrero guerreros) {
        if (listaGuerreros.size() > 10) {
            logger.error("No se pueden embarcar más de 10 guerreros");
            return;
        } else {
            listaGuerreros.add(guerreros);
            logger.info("Los guerreros se han embarcado...");
        }
    }

    // ============================== CAMBIOS VIKTOR ==============================
    // //
    public void crearVehiculoGuerra() {
        mapaVehiculoGuerra.put(TanqueMantis.class, new ArrayList<Guerrero>());
        mapaVehiculoGuerra.put(NaveDepredadora.class, new ArrayList<Guerrero>());
    }

    public void embarcarGuerrero(VehiculoGuerra tipo, Guerrero guerrero) {
        try {
            List<Guerrero> listaGuerreros = mapaVehiculoGuerra.get(tipo.getClass());
            int maxGuerreros = 10;

            if (listaGuerreros == null) {
                throw new IllegalArgumentException("El tipo de nave no es válido");
            }

            if (tipo instanceof TanqueMantis && !(guerrero instanceof Mantis)) {
                throw new IllegalArgumentException("Solo los guerreros de tipo Mantis pueden embarcar en un Tanque");
            }

            if (tipo instanceof NaveDepredadora && !(guerrero instanceof Depredador)) {
                throw new IllegalArgumentException(
                        "Solo los guerreros de tipo Depredador pueden embarcar en una Nave Depredadora");
            }

            if (listaGuerreros.size() == maxGuerreros) {
                throw new TooManyGuerreros(
                        "No se pueden embarcar más de " + maxGuerreros + " guerreros en la nave " + tipo);
            }

            listaGuerreros.add(guerrero);
            logger.info("Guerrero embarcado en " + tipo);

        } catch (IllegalArgumentException | TooManyGuerreros e) {
            logger.error("Error al embarcar guerrero: " + e.getMessage());
        }
    }

    public void mostrarGuerreros() {
        for (Class<?> tipo : mapaVehiculoGuerra.keySet()) {
            List<Guerrero> listaGuerreros = mapaVehiculoGuerra.get(tipo);
            logger.info("Vehículo: " + tipo + " - Guerreros: " + listaGuerreros.size());
        }
    }
    // ==============================================================================
    // //

    // Ataque: ataque VehiculoGuerra*(random 0-1) + SUM (fuerza de todos los
    // guerreros) * (random 0-0.5)

    // Defensa: defensa VehiculoGuerra*(random 0-1) + SUM (Resistencia de todos los
    // guerreros) * (random 0-0.5)

    @Override
    public String toString() {
        return "VehiculoGuerra [puntosVida=" + puntosVida + ", ataque=" + ataque + ", defensa=" + defensa + ", nombre="
                + nombre + ", tipo=" + tipo + ", listaGuerreros=" + listaGuerreros + "]";
    }

    // Getters y Setters
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
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int atacar() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int defender(int danho) {
        // TODO Auto-generated method stub
        return 0;
    }

    // VIKTOR: añadimos el alcance.
    @Override
    public int alcance() {
        // TODO Auto-generated method stub
        return 0;
    }

    // Pendiente
    public void embarcarGuerrero() {

    }

}
