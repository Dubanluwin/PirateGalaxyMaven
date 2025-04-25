package es.cursojava.hibernate.dao;

import java.util.List;

import es.cursojava.hibernate.entity.claseshijas.guerreros.Depredador;
import es.cursojava.hibernate.entity.claseshijas.guerreros.Mantis;
import es.cursojava.hibernate.entity.clasespadres.VehiculoGuerra;
import es.cursojava.proyecto.clases.clasespadres.Guerrero;

public class GuerreroDAOImpl implements GuerreroDAO{

    @Override
    public List<Guerrero> crearGuerreroDepredadora() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Guerrero> crearGuerreroMantis() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void mostrarGuerreros(List<Guerrero> guerrero) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insertarGuerrero(Depredador depredador, Mantis mantis) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void controlarFuerzaResistencia(int fuerza, int resistencia) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int apoyoAtaque() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int apoyoDefensa() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void embarcarGuerrero(VehiculoGuerra vehiculo, List<Guerrero> guerreros) {
        // TODO Auto-generated method stub
        
    }


}
