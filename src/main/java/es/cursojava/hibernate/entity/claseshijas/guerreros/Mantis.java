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
@Table(name = "TB_MANTIS")
public class Mantis extends Guerrero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idNaveDepredadora;

    @Column(name = "planeta_mantis", length = 20, unique = true)
    protected String planetaMantis;

    @ManyToOne
    @JoinColumn(name = "FK_VEHICULO_GUERRA_MANTIS")
    private VehiculoGuerra vehiculoGuerra;

    public Mantis(String nombreGuerrero, String tipoGuerrero, int fuerza, int resistencia, String planetaMantis)
            throws TooManyFuerzaResistencia {
        super(nombreGuerrero, tipoGuerrero, fuerza, resistencia);
        this.planetaMantis = planetaMantis;
    }

    public String getPlanetaMantis() {
        return planetaMantis;
    }

    public void setPlanetaMantis(String planetaMantis) {
        this.planetaMantis = planetaMantis;
    }

    @Override
    public int apoyoAtaque() {

        double factorFuerzaMantis = Math.random() * 0.5;
        int sumaFuerzaMantis = getFuerza();

        return (int) (sumaFuerzaMantis * factorFuerzaMantis);
    }

    @Override
    public int apoyoDefensa() {

        double factorDefensaMantis = Math.random() * 0.5;
        int sumaResistenciaMantis = getResistencia();

        return (int) (sumaResistenciaMantis * factorDefensaMantis);
    }

}
