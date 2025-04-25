package es.cursojava.hibernate.dao;

import java.util.List;

import es.cursojava.hibernate.entity.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.hibernate.entity.claseshijas.vehiculos.TanqueMantis;
import es.cursojava.proyecto.clases.clasespadres.Guerrero;
import es.cursojava.proyecto.clases.clasespadres.VehiculoGuerra;

public class VehiculoGuerraDAOImpl implements VehiculoGuerraDAO{

    @Override
    public List<Guerrero> crearNaveDepredadora() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Guerrero> crearTanqueMantis() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void embarcarGuerrero(VehiculoGuerra vehiculo, List<Guerrero> guerreros) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insertarNaves(NaveDepredadora naveDepredadora, TanqueMantis tanqueMantis) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void controlarPuntosVida(int puntosVida) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String barraVida(int puntosVida) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void controlarAtaqueDefensa(int ataque, int defensa) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int atacar() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int defender() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getUltimaDefensa() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getUltimoDanioRecibido() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public VehiculoGuerra preparacionBatalla(VehiculoGuerra tanqueMantis, VehiculoGuerra naveDepredadora) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void iniciarBatalla(VehiculoGuerra vehiculoProfe) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ataqueDeNave(VehiculoGuerra combatiente, VehiculoGuerra vehiculoProfe) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ataqueDeTanque(VehiculoGuerra vehiculoProfe, VehiculoGuerra combatiente) {
        // TODO Auto-generated method stub
        
    }
    
}
