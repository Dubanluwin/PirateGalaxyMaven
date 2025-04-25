package es.cursojava.hibernate.dao;

import java.util.List;

import es.cursojava.hibernate.entity.claseshijas.guerreros.Depredador;
import es.cursojava.hibernate.entity.claseshijas.guerreros.Mantis;
import es.cursojava.hibernate.entity.clasespadres.VehiculoGuerra;
import es.cursojava.proyecto.clases.clasespadres.Guerrero;

public interface GuerreroDAO {
    List<Guerrero> crearGuerreroDepredadora();
    List<Guerrero> crearGuerreroMantis();
    void mostrarGuerreros(List<Guerrero> guerrero);
    void insertarGuerrero(Depredador depredador, Mantis mantis);
    void controlarFuerzaResistencia(int fuerza, int resistencia);
    int apoyoAtaque();
    int apoyoDefensa();
    void embarcarGuerrero(VehiculoGuerra vehiculo, List<Guerrero> guerreros);
}
