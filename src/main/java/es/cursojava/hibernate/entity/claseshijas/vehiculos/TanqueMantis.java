package es.cursojava.hibernate.entity.claseshijas.vehiculos;

import es.cursojava.hibernate.entity.clasespadres.VehiculoGuerra;
import es.cursojava.hibernate.exception.TooManyAtaqueDefensa;
import es.cursojava.hibernate.exception.TooManyHp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TANQUE_MANTIS")
public class TanqueMantis extends VehiculoGuerra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idTanqueMantis;

    @ManyToOne
    @JoinColumn(name = "FK_TANQUE_DE_GUERRA")
    protected VehiculoGuerra tanqueGuerra;

    public TanqueMantis(String nombreVehiculoGuerra, int puntosVida, int ataque, int defensa, String tipoVehiculoGuerra)
            throws TooManyAtaqueDefensa, TooManyHp {
        super(nombreVehiculoGuerra, puntosVida, ataque, defensa, tipoVehiculoGuerra);
    }

    @Override
    public int atacar() {
        return super.atacar();
    }

    @Override
    public int defender(int ataqueEntrante) {
        return super.defender(ataqueEntrante);
    }

    @Override
    public int alcance() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "Tanque Mantis []";
    }

}
