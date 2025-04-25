package es.cursojava.hibernate.dao;

import java.util.List;

import es.cursojava.hibernate.entity.claseshijas.vehiculos.NaveDepredadora;
import es.cursojava.hibernate.entity.claseshijas.vehiculos.TanqueMantis;
import es.cursojava.proyecto.clases.clasespadres.Guerrero;
import es.cursojava.proyecto.clases.clasespadres.VehiculoGuerra;

public interface VehiculoGuerraDAO {
    List<Guerrero> crearNaveDepredadora();
    List<Guerrero> crearTanqueMantis();
    void embarcarGuerrero(VehiculoGuerra vehiculo, List<Guerrero> guerreros);
    void insertarNaves(NaveDepredadora naveDepredadora, TanqueMantis tanqueMantis);
    void controlarPuntosVida(int puntosVida);
    String barraVida(int puntosVida);
    void controlarAtaqueDefensa(int ataque, int defensa);
    int atacar();
    int defender();
    int getUltimaDefensa();
    int getUltimoDanioRecibido();
    VehiculoGuerra preparacionBatalla(VehiculoGuerra tanqueMantis, VehiculoGuerra naveDepredadora);
    void iniciarBatalla(VehiculoGuerra vehiculoProfe);
    void ataqueDeNave(VehiculoGuerra combatiente, VehiculoGuerra vehiculoProfe);
    void ataqueDeTanque(VehiculoGuerra vehiculoProfe, VehiculoGuerra combatiente);
}
