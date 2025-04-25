package es.cursojava.hibernate.entity.clasespadres;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "TB_GUERRERO")
public abstract class Guerrero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idGuerrero;

    @Column(name = "nombre_guerrero", nullable = false, length = 20)
    protected String nombreGuerrero;
    
    @Column(name = "tipo_guerrero", nullable = false, length = 20)
    protected String tipoGuerrero;

    @Column(name = "fuerza", nullable = false, length = 20)
    protected int fuerza;

    @Column(name = "resistencia", nullable = false, length = 20)
    protected int resistencia;

    // Aqui tampoco se muy bien que poner
    @OneToMany(mappedBy = "guerreros", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected List<Guerrero> listaGuerreros = new ArrayList<>();
    
    // Constructores
    public Guerrero() {
    }

    public Guerrero(String nombreGuerrero, String tipoGuerrero, int fuerza, int resistencia) {
        this.nombreGuerrero = nombreGuerrero;
        this.tipoGuerrero = tipoGuerrero;
        this.fuerza = fuerza;
        this.resistencia = resistencia;
    }

    // Getters publicos y Setters privados
    public Long getIdGuerrero() {
        return idGuerrero;
    }

    private void setIdGuerrero(Long idGuerrero) {
        this.idGuerrero = idGuerrero;
    }

    public String getNombreGuerrero() {
        return nombreGuerrero;
    }

    private void setNombreGuerrero(String nombreGuerrero) {
        this.nombreGuerrero = nombreGuerrero;
    }

    public String getTipoGuerrero() {
        return tipoGuerrero;
    }

    private void setTipoGuerrero(String tipoGuerrero) {
        this.tipoGuerrero = tipoGuerrero;
    }

    public int getFuerza() {
        return fuerza;
    }

    private void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    private void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public List<Guerrero> getListaGuerreros() {
        return listaGuerreros;
    }

    private void setListaGuerreros(List<Guerrero> listaGuerreros) {
        this.listaGuerreros = listaGuerreros;
    }

    // - - - - - - - - - - - 
    public int apoyoAtaque() {

        return fuerza;
    }

    public int apoyoDefensa() {

        return resistencia;
    }

}
