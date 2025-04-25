package es.cursojava.proyecto.excepciones;

public class TooManyStats extends Exception {

    public TooManyStats(String mensaje) {
        super(mensaje);
    }

}
