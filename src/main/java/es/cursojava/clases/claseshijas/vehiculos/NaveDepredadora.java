package com.pirategalaxy.clases.claseshijas.vehiculos;

import java.util.List;
import java.util.Map;

import com.pirategalaxy.clases.clasespadres.Guerrero;
import com.pirategalaxy.clases.clasespadres.VehiculoGuerra;
import com.pirategalaxy.excepciones.TooManyAtaqueDefensa;

public class NaveDepredadora extends VehiculoGuerra {

    public NaveDepredadora(int puntosVida, int ataque, int defensa, String nombre, String tipo,
            List<Guerrero> listaGuerreros, Map<Class<?>, List<Guerrero>> mapaVehiculoGuerra) throws TooManyAtaqueDefensa {
        super(puntosVida, ataque, defensa, nombre, tipo, listaGuerreros, mapaVehiculoGuerra);
            
    }

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
            throw new IllegalArgumentException("Solo los guerreros de tipo Depredador pueden embarcar en la NaveDepredadora.");
        }
        super.embarcar(guerrero);
    }

}
