package com.pirategalaxy.clases.claseshijas.vehiculos;

import java.util.List;
import java.util.Map;

import com.pirategalaxy.clases.clasespadres.Guerrero;
import com.pirategalaxy.clases.clasespadres.VehiculoGuerra;
import com.pirategalaxy.excepciones.TooManyAtaqueDefensa;

public class TanqueMantis extends VehiculoGuerra {

    public TanqueMantis(int puntosVida, int ataque, int defensa, String nombre, String tipo,
            List<Guerrero> listaGuerreros, Map<Class<?>, List<Guerrero>> mapaVehiculoGuerra) throws TooManyAtaqueDefensa {
        super(puntosVida, ataque, defensa, nombre, tipo, listaGuerreros, mapaVehiculoGuerra);
    }

    @Override
    public int atacar() {
        if (puntosVida <= 500) {
            ataque += 10;
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

    // // SE PUEDE MODIFICAR EL METODO (( HE UTILIZADO EL MISMO DE LA NAVE
    // // DESTRUCTORA))

    // // atacar(): devuelve un valor calculado con la fórmula del diagrama (p. ej.
    // // ataque base + suma del ataque de los guerreros).

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

    // // SE PUEDE MODIFICAR EL METODO (( HE UTILIZADO EL MISMO DE LA NAVE
    // // DESTRUCTORA))

    // // defender(): devuelve un valor calculado con la fórmula del diagrama (p.
    // ej.
    // // defensa base + suma de la defensa de los guerreros). Con el valor devuelto
    // // por el método defender se quitarán los puntos de vida de la nave.

    // int defensaTotal = defensa;
    // for (Guerrero guerrero : listaGuerreros) {
    // defensaTotal += guerrero.apoyoDefensa(); // Los guerreros suman a la defensa
    // }
    // int danhoRecibido = Math.max(0, danho - defensaTotal); // Si el daño es menor
    // que la defensa, no se recibe daño
    // puntosVida -= danhoRecibido;
    // System.out.println(this.nombre + " recibe " + danhoRecibido + " de daño, vida
    // restante: " + puntosVida);
    // return danhoRecibido;
    // }

    
    // VIKTOR: añadimos el alcance con su fórmula.
    @Override
    public int alcance() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "Tanque []";
    }

    @Override
    public void embarcar(Guerrero guerrero) {
        if (!guerrero.getTipo().equalsIgnoreCase("Mantis")) {
            throw new IllegalArgumentException("Solo los guerreros de tipo Mantis pueden embarcar en la Tanque.");
        }
        super.embarcar(guerrero);
    }

}
