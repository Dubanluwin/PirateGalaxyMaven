package es.cursojava.hibernate.entity.claseshijas.guerreros;

import es.cursojava.hibernate.entity.clasespadres.Guerrero;
import es.cursojava.hibernate.entity.clasespadres.VehiculoGuerra;
import es.cursojava.hibernate.exception.TooManyFuerzaResistencia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_DEPREDADOR")
public class Depredador extends Guerrero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idDepredador;

    @Column(name = "planeta_depredador", length = 20, unique = true)
    protected String planetaDepredador;

    @ManyToOne
    @JoinColumn(name = "FK_VEHICULO_GUERRA_DEPREDADOR")
    private VehiculoGuerra vehiculoGuerra;

    public Depredador(String nombreGuerrero, String tipoGuerrero, int fuerza, int resistencia, String planetaDepredador)
            throws TooManyFuerzaResistencia {
        super(nombreGuerrero, tipoGuerrero, fuerza, resistencia);
        this.planetaDepredador = planetaDepredador;
    }

    public String getPlanetaDepredador() {
        return planetaDepredador;
    }

    public void setPlanetaDepredador(String planetaDepredador) {
        this.planetaDepredador = planetaDepredador;
    }

    @Override
    public int apoyoAtaque() {

        double factorFuerzaDepredador = Math.random() * 0.5;
        int sumaFuerzaDepredador = getFuerza();

        return (int) (sumaFuerzaDepredador * factorFuerzaDepredador);
    }

    @Override
    public int apoyoDefensa() {

        double factorDefensaDepredador = Math.random() * 0.5;
        int sumaResistenciaDepredador = getResistencia();

        return (int) (sumaResistenciaDepredador * factorDefensaDepredador);
    }

}
