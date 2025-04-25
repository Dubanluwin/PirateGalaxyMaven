package es.cursojava.hibernate.entity.claseshijas.vehiculos;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.hibernate.entity.clasespadres.Guerrero;
import es.cursojava.hibernate.entity.clasespadres.VehiculoGuerra;
import es.cursojava.hibernate.exception.TooManyAtaqueDefensa;
import es.cursojava.hibernate.exception.TooManyGuerreros;
import es.cursojava.hibernate.exception.TooManyHp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_NAVE_DEPREDADORA")
public class NaveDepredadora extends VehiculoGuerra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idNaveDepredadora;

    @ManyToOne
    @JoinColumn(name = "FK_NAVE_DE_GUERRA")
    protected VehiculoGuerra naveGuerra;

    // Constructores
    public NaveDepredadora() {
    }

    public NaveDepredadora(String nombreVehiculoGuerra, int puntosVida, int ataque, int defensa, String tipoVehiculoGuerra)
            throws TooManyAtaqueDefensa, TooManyHp {
        super(nombreVehiculoGuerra, puntosVida, ataque, defensa, tipoVehiculoGuerra);
        
    }

    @Override
    public int atacar() {
        return super.atacar();
    }

    @Override
    public int defender(int ataqueRecibido) {
        return super.defender(ataqueRecibido);
    }

    @Override
    public int alcance() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "NaveDestructora []";
    }

}
