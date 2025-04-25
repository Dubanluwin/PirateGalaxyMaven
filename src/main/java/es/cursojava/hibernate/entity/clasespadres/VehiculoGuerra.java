package es.cursojava.hibernate.entity.clasespadres;

import java.util.ArrayList;
import java.util.List;

import es.cursojava.hibernate.interfaz.Tripulable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_VEHICULO_GUERRA")
public abstract class VehiculoGuerra implements Tripulable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idVehiculoGuerra;

    @Column(name = "nombre_vehiculo_guerra", nullable = false, length = 20)
    protected String nombreVehiculoGuerra;

    @Column(name = "puntos_vida", nullable = false, length = 4)
    protected int puntosVida;

    @Column(name = "ataque", nullable = false, length = 2)
    protected int ataque;
    
    @Column(name = "defensa", nullable = false, length = 2)
    protected int defensa;
    
    @Column(name = "tipo_vehiculo_guerra", length = 20)
    protected String tipoVehiculoGuerra;

    // Esta parte me confunde, porque de esta clase heredan 2 vehiculos (la nave y el tanque).
    // ¿Tiene que ser una lista de vehiculos o 2 listas con los nombres de nuestros vehiculos?
    @OneToMany(mappedBy = "vehiculoGuerra", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected List<Guerrero> listaGuerreros = new ArrayList<>();

    // No se que hacer con estos Xd
    private boolean estadisticasModificadas;
    private int ultimaDefensa;
    private int ultimoDanioRecibido;
    // = = = = = = = = = = = = = = = = =

    // Constructores
    public VehiculoGuerra() {
    }

    public VehiculoGuerra(String nombreVehiculoGuerra, int puntosVida, int ataque, int defensa, String tipoVehiculoGuerra) {
        this.nombreVehiculoGuerra = nombreVehiculoGuerra;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.tipoVehiculoGuerra = tipoVehiculoGuerra;
    }

    // Getters publicos y Setters privados
    public int getPuntosVida() {
        return puntosVida;
    }

    private void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getAtaque() {
        return ataque;
    }

    private void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    private void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public String getNombreVehiculoGuerra() {
        return nombreVehiculoGuerra;
    }

    public void setNombreVehiculoGuerra(String nombreVehiculoGuerra) {
        this.nombreVehiculoGuerra = nombreVehiculoGuerra;
    }

    public List<Guerrero> getListaGuerreros() {
        return listaGuerreros;
    }

    private void setListaGuerreros(List<Guerrero> listaGuerreros) {
        this.listaGuerreros = listaGuerreros;
    }

    public String getTipoVehiculoGuerra() {
        return tipoVehiculoGuerra;
    }

    private void setTipoVehiculoGuerra(String tipoVehiculoGuerra) {
        this.tipoVehiculoGuerra = tipoVehiculoGuerra;
    }

    // - - - - - - - - - - - - - - - - - - 
    public int getUltimaDefensa() {
        return ultimaDefensa;
    }
    
    public int getUltimoDanioRecibido() {
        return ultimoDanioRecibido;
    }

   
}
