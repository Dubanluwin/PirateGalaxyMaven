package com.pirategalaxy;

import java.util.ArrayList;
import java.util.List;

import com.pirategalaxy.clases.claseshijas.vehiculos.TanqueMantis;
import com.pirategalaxy.clases.clasespadres.Guerrero;
import com.pirategalaxy.clases.clasespadres.VehiculoGuerra;

public class Propuestas {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // ===================== VIKTOR: Propuestas para la clase Tanque
    // =====================

    // @Override
    // public int atacar() {
    // if (puntosVida <= 500) {
    // ataque += 10;
    // }
    // int ataqueTotal = (int) (ataque * Math.random());
    // for (Guerrero guerrero : listaGuerreros) {
    // ataqueTotal += guerrero.fuerza * Math.random() * 0.5;
    // }
    // return ataqueTotal;
    // }

    // @Override
    // public int defender(int ataqueRecibido) {
    // int defensaTotal = (int) (defensa * Math.random());
    // for (Guerrero g : listaGuerreros) {
    // defensaTotal += g.resistencia * Math.random() * 0.5;
    // }
    // int daño = ataqueRecibido - defensaTotal;
    // puntosVida -= Math.max(daño, 0);
    // return Math.max(daño, 0);
    // }

    // ===================== VIKTOR: Propuestas para la clase NaveDepredadora
    // =====================

    // @Override
    // public int atacar() {
    // if (puntosVida <= 650) {
    // ataque -= 2;
    // defensa += 4;
    // }
    // int ataqueTotal = (int) (ataque * Math.random());
    // for (Guerrero guerrero : listaGuerreros) {
    // ataqueTotal += guerrero.fuerza * Math.random() * 0.5;
    // }
    // return ataqueTotal;
    // }

    // @Override
    // public int defender(int ataqueRecibido) {
    // int defensaTotal = (int) (defensa * Math.random());
    // for (Guerrero guerrero : listaGuerreros) {
    // defensaTotal += guerrero.resistencia * Math.random() * 0.5;
    // }
    // int daño = ataqueRecibido - defensaTotal;
    // puntosVida -= Math.max(daño, 0);
    // return Math.max(daño, 0);
    // }

    // Propuesta para que se enfrenten dos naves iguales.
    // ===================== VIKTOR: Propuestas para la clase CampoDeBatalla
    // =====================

    // List<VehiculoGuerra> equipo1 = new ArrayList<>();
    // List<VehiculoGuerra> equipo2 = new ArrayList<>();

    // equipo1.add(new Tanque("Tanque Destructor"));
    // equipo1.add(new NaveDestructora("Nave Devastadora"));

    // equipo2.add(new Tanque("Tanque Enemigo"));
    // equipo2.add(new NaveDestructora("Nave Enemiga"));

    // equipo1.get(0).embarcarGuerrero(new Mantis("mantis1"));
    // equipo2.get(0).embarcarGuerrero(new Depredador("depredador1"));

    // System.out.println("Empieza la batalla!");
    // while (!equipo1.isEmpty() && !equipo2.isEmpty()) {
    // VehiculoGuerra atacante = equipo1.get(0);
    // VehiculoGuerra defensor = equipo2.get(0);

    // int ataque = atacante.atacar();
    // int daño = defensor.defender(ataque);
    // System.out.println(atacante.nombre + " ataca con " + ataque + " puntos. " +
    // defensor.nombre + " recibe " + daño + " de daño.");

    // if (defensor.puntosVida <= 0) {
    // equipo2.remove(0);
    // continue;
    // }

    // VehiculoGuerra ciclo = atacante;
    // atacante = defensor;
    // defensor = ciclo;
    // }

    // if (!equipo1.isEmpty()) {
    // System.out.println("¡El equipo 1 gana la batalla!");
    // } else {
    // System.out.println("¡El equipo 2 gana la batalla!");
    // }
}