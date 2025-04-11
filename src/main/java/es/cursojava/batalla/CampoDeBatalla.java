package es.cursojava.batalla;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.cursojava.clases.claseshijas.guerreros.Mantis;
import es.cursojava.clases.claseshijas.vehiculos.TanqueMantis;
import es.cursojava.clases.clasespadres.Guerrero;
import es.cursojava.clases.clasespadres.VehiculoGuerra;
import es.cursojava.excepciones.TooManyAtaqueDefensa;
import es.cursojava.excepciones.TooManyFuerzaResistencia;
import es.cursojava.excepciones.TooManyGuerreros;
import es.cursojava.excepciones.TooManyHp;

public class CampoDeBatalla {

    private static final Logger logger = LoggerFactory.getLogger(CampoDeBatalla.class);

    public static void main(String[] args) {
        List<Guerrero> guerrerosProfe = null;
        try {

            Guerrero mantisProfe = new Mantis("J", "Mantis", 10, 5, "A");

            mantisProfe.apoyoAtaque();
            guerrerosProfe = ConfiguracionBatalla.crearMantis();

            VehiculoGuerra vehiculoJose = new TanqueMantis(1000, 5, 5, "El Corredor", "Sport",
                    guerrerosProfe);

            ConfiguracionBatalla.iniciarBatalla(vehiculoJose);

        } catch (TooManyAtaqueDefensa e) {
            e.printStackTrace();
        } catch (TooManyHp e) {
            e.printStackTrace();
        } catch (TooManyFuerzaResistencia e) {
            e.printStackTrace();
        } catch (TooManyGuerreros e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
