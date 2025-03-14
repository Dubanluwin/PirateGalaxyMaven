package es.cursojava.clases.claseshijas.vehiculos;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.batalla.CampoDeBatalla;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.clases.clasespadres.VehiculoGuerra;

public class NaveDepredadora extends VehiculoGuerra {
    
    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    public NaveDepredadora(int puntosVida, int ataque, int defensa, String nombre, String tipo,
            List<Guerrero> listaGuerreros, Map<Class<?>, List<Guerrero>> mapaVehiculoGuerra) {
        super(puntosVida, ataque, defensa, nombre, tipo, listaGuerreros, mapaVehiculoGuerra);    
    }

    // Controlar para que se ejecute al azar
    @Override
    public int atacar() {
        if (puntosVida <= 650) {
            ataque -= 2;
            defensa += 4;
        }
        int ataqueTotal = (int) (ataque * Math.random());
        for (Guerrero guerrero : listaGuerreros) {
            ataqueTotal += guerrero.getFuerza() * Math.random() * 0.5;
        }
        return ataqueTotal;
    }

    @Override
    public int defender(int ataqueRecibido) {
        int defensaTotal = (int) (defensa * Math.random());
        for (Guerrero guerrero : listaGuerreros) {
            defensaTotal += guerrero.getResistencia() * Math.random() * 0.5;
        }
        int daño = ataqueRecibido - defensaTotal;
        puntosVida -= Math.max(daño, 0);
        return Math.max(daño, 0);
    }

    // Método defender con ternario.
    // @Override
    // public int defender(int ataqueRecibido) {
    //     int defensaTotal = (int) (defensa * Math.random());
        
    //     for (Guerrero guerrero : listaGuerreros) {
    //         defensaTotal += guerrero.getResistencia() * Math.random() * 0.5;
    //     }
        
    //     int daño = ataqueRecibido - defensaTotal;
        
    //     if (daño > 0) { // Solo restar si el daño es positivo
    //         puntosVida -= daño;
    //     }
        
    //     return (daño > 0) ? daño : 0;
    // }

    // @Override
    // public int atacar() {
    // // atacar(): similar a Tanque, pero con su propia lógica de ataque (p. ej.
    // // ataque base + bonificación de guerreros).

    // int danhoTotal = ataque;
    // for (Guerrero guerrero : listaGuerreros) {
    // danhoTotal += guerrero.apoyoAtaque(); // Los guerreros suman al ataque
    // }
    // System.out.println(this.nombre + " realiza un ataque con daño total: " +
    // danhoTotal);
    // return danhoTotal;

    // }

    // @Override
    // public int defender(int danho) {

    // // defender(): lógica de defensa particular.

    // int defensaTotal = defensa;
    // for (Guerrero guerrero : listaGuerreros) {
    // defensaTotal += guerrero.apoyoDefensa(); // Los guerreros suman a la defensa
    // }
    // int danioRecibido = Math.max(0, danho - defensaTotal); // Si el daño es menor
    // que la defensa, no se recibe daño
    // puntosVida -= danioRecibido;
    // System.out.println(this.nombre + " recibe " + danioRecibido + " de daño, vida
    // restante: " + puntosVida);
    // return danioRecibido;
    // }

    // VIKTOR: añadimos el alcance con su fórmula.
    @Override
    public int alcance() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "NaveDestructora []";
    }

    @Override
    public void embarcar(Guerrero guerrero) {

        if (!guerrero.getTipo().equalsIgnoreCase("Depredador")) {
            throw new IllegalArgumentException(
                    "Solo los guerreros de tipo Depredador pueden embarcar en la NaveDepredadora.");
        }
        super.embarcar(guerrero);
    }

}
