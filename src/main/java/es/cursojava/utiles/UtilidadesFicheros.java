package es.cursojava.utiles;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilidadesFicheros {
    private static final Logger logger = LoggerFactory.getLogger(UtilidadesFicheros.class);
    public static final String SEPARADOR_PIPE = " | ";

    // Como se repite el código en los 2 métodos, hacemos que uno llame al otro.
    // Para convertir un Array de Strings en una lista utilizamos el Arrays.asList()
    public static void crearDirectorios (File directorioFicheros, String[] directorios) {
        crearDirectorios(directorioFicheros, Arrays.asList(directorios));
    }

    // Ponemos Collection para poder poner tanto una List como un Set, ya que ambas heredan de Collection.
    public static void crearDirectorios (File directorioFicheros, Collection<String> directorios) {
        for (String directorio : directorios) {
            File directorioImagenes = new File(directorioFicheros, directorio);
            if (directorioImagenes.mkdir()) {
                logger.info("El directorio " + directorio + " se ha creado.");
            } else {
                logger.warn("El directorio " + directorio + " no se ha creado.");
            }
        }
    }

    

}
