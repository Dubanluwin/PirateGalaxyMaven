package es.cursojava.utiles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utilidades {
	
	public static int pideDatoNumerico(String texto) {
		System.out.print(texto);
		Scanner scan = new Scanner(System.in);
		int numero = scan.nextInt();
	
		return numero;
	}
	
	public static String pideDatoCadena(String texto) {
		System.out.print(texto);
		Scanner scan = new Scanner(System.in);
		String cadena = scan.nextLine();
		
		return cadena;
	}
    
    // public static double pideDatoDecimal(String texto) {
	// 	System.out.print(texto);
	// 	Scanner scan = new Scanner(System.in);
	// 	double numero = scan.nextInt();

	// 	return numero;
	// }

    public static double pideDatoDecimal(String texto) {
        System.out.print(texto);
        Scanner scan = new Scanner(System.in);
        double numero = 0;
        boolean valido = false;

        while (!valido) {
            try {
                String entrada = scan.next(); // Leer como String
                entrada = entrada.replace(',', '.'); // Reemplazar coma por punto
                numero = Double.parseDouble(entrada); // Convertir a double
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Error: Ingresa un número decimal válido.");
            }
        }
        return numero;
    }

    public static Date pideDatoFecha(String texto) {
        System.out.print(texto);
        Scanner scan = new Scanner(System.in);
        String fechaStr = scan.nextLine();
        Date fecha = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            fecha = formato.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Error: Formato de fecha inválido. Usa dd/MM/yyyy.");
        }
        return fecha;
    }

    /**
     * Funcion que sirve para pintar las opciones de un menu que llegan en un array de Strings.
     * @param menuArray: Array de Strings con las opciones del menu
     * @autor: Viktor
     * @since: 1.0
     */
	public static void pintarMenu(String[] menuArray) {
		for (String opcion : menuArray) {
			System.out.println(opcion);
		}
	}

    // OTRA MANERA DE PINTAR EL MENU
    // public static void pintaMenu (String menuStr){
    //     String[] opciones = menuStr.split(";");
    //     pintarMenu(opciones);
    // }
	
	public static void datosAlumnos (String[][] aulas){
        for (int i = 0; i < aulas.length; i++) {
            System.out.println("Aula " + (i + 1) + ":");
            for (int j = 0; j < 5; j++) {
                System.out.print("Introduce el nombre del alumno para la mesa " + (j + 1) + ": ");
                aulas[i][j] = pideDatoCadena("");
            }
        }
    }

	public static void mostrarAlumnos (String[][] aulas){
		for (int i = 0; i < aulas.length; i++) {
			System.out.println("Aula " + (i + 1) + ":");
			for (int j = 0; j < 5; j++) {
				System.out.println("Mesa " + (j + 1) + ": " + (aulas[i][j] == null ? "Vacío" : aulas[i][j]));
			}
		}
	}

    /**
     * Funcion que sirve para busca un alumno en las aulas de un colegio que llegan en un array de Strings.
     * @param aulas
     * @autor: Viktor
     * @since: 1.0
     */
	public static void buscarAlumno (String[][] aulas){
		pideDatoCadena("Introduce el nombre del alumno que deseas buscar: ");
        String nombreBuscado = pideDatoCadena("");
        boolean encontrado = false;

        for (int i = 0; i < aulas.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (aulas[i][j] != null && aulas[i][j].equalsIgnoreCase(nombreBuscado)) {
                    System.out.println("El alumno " + nombreBuscado + " está en el aula " + (i + 1) + ", mesa " + (j + 1));
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                break;
            }
        }

        if (!encontrado) {
        System.out.println("El alumno " + nombreBuscado + " no se encuentra en ninguna aula.");
        }
	}

	public static void borrarAlumno (String[][] aulas){
		pideDatoCadena("Introduce el nombre del alumno que deseas borrar: ");
        String nombreBorrar = pideDatoCadena("");
        boolean borrado = false;

        for (int i = 0; i < aulas.length; i++) {
            for (int j = 0; j < 5; j++) {
                if (aulas[i][j] != null && aulas[i][j].equalsIgnoreCase(nombreBorrar)) {
                    aulas[i][j] = null;
                    System.out.println("El alumno " + nombreBorrar + " ha sido eliminado del aula " + (i + 1) + ", mesa " + (j + 1));
                    borrado = true;
                    break;
                }
            }
        }

        if (!borrado) {
            System.out.println("El alumno " + nombreBorrar + " no se encuentra en ninguna aula.");
        }
	}

    public static void validarEmail (String texto) {
        String email = "   asdasd@asqweasd  ";
		email = email.toLowerCase().trim();
		// email = email.replace(" ", "");
		String error = "";
		System.out.println(email.substring(email.indexOf("@") + 1));

		email.indexOf("sfs");

		if (email.contains(" ") || email.contains("\t")) {
			error += "Tiene espacio en blanco.\n";
		}
		if (email.indexOf("@") != email.lastIndexOf("@")) {
			error += "El email solo puede contener una @\n";
		}

		if (!email.contains("@")) {
			error += "El email debe contener una @\n";
		} else {// Si tienes @
			if (email.indexOf("@") > email.lastIndexOf(".")) {
				error += "Tiene que haber un punto después de la @\n";
			}else {
				String dominio = email.substring(email.indexOf("@")+1);
				if (dominio.indexOf(".") < 2) {
					error += "Tiene que haber una separación de dos o más "
							+ "caracteres entre la @ y el primer punto "
							+ "después de la @\n";
				}
				//asd.asda@s.dasfsd.ekhfykfr
				String subDominio = dominio.substring(dominio.lastIndexOf(".")+1);
				if (subDominio.length()<2 || subDominio.length()>6) {
					error += "Después del último punto debe haber entre 2 y 6 caracteres\n";
				}
			}
		}

		if (error.isBlank()) {
			System.out.println("El email " + email + " es correcto");
		} else {
			System.out.println("El email " + email + " es incorrecto por:\n" + error);
		}

	}
    
}
