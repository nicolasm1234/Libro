import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LibroImpreso libroI = new LibroImpreso("Java Inicial", "Jesus Roa", 80.00, 4, 1.7, 1);
        LibroDigital libroD = new LibroDigital("Java Avanzado", "Sandra Pinilla", 70.50, 8, 3.5, true);

        int opcion;

        do {
            System.out.println("MENÚ BIBLIOTECA ");
            System.out.println("1. Mostrar Libro Impreso");
            System.out.println("2. Mostrar Libro Digital");
            System.out.println("3. Prestar/Devolver");
            System.out.println("4. Salir");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        libroI.mostrarLibro();
                        break;
                    case 2:
                        libroD.mostrarLibro();
                        break;
                    case 3:
                        gestionarLibro(sc, libroI, libroD);
                        break;
                    case 4:
                        System.out.println("Adiós");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } else {
                System.out.println("Entrada inválida. Ingresa un número.");
                sc.nextLine();
                opcion = 0;
            }

        } while (opcion != 4);

        sc.close();
    }

    private static void gestionarLibro(Scanner sc, LibroImpreso impreso, LibroDigital digital) {
        System.out.print("Ingrese el título exacto a buscar: ");
        String tituloBuscado = sc.nextLine().trim();

        if (tituloBuscado.equalsIgnoreCase(impreso.titulo)) {
            interactuar(sc, impreso, "impreso");
        } else if (tituloBuscado.equalsIgnoreCase(digital.titulo)) {
            interactuar(sc, digital, "digital");
        } else {
            System.out.println(" Libro '" + tituloBuscado + "' no encontrado.");
        }
    }

    private static void interactuar(Scanner sc, Libro libro, String tipo) {
        libro.mostrarLibro();
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Prestar");
        System.out.println("2. Devolver");
        System.out.print("Opción (1/2): ");

        if (!sc.hasNextInt()) {
            System.out.println("Opción inválida.");
            sc.nextLine();
            return;
        }
        int accion = sc.nextInt();
        sc.nextLine();

        int cantidad = 0;
        if (accion == 1) {
            System.out.print("¿Cuántos ejemplares? ");
        } else if (accion == 2 && tipo.equals("impreso")) {
            System.out.print("¿Cuántos ejemplares a devolver? ");
        }

        if (accion == 1 || (accion == 2 && tipo.equals("impreso"))) {
            if (sc.hasNextInt()) {
                cantidad = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Cantidad inválida.");
                sc.nextLine();
                return;
            }
        }

        switch (accion) {
            case 1:
                if (tipo.equals("impreso")) {
                    ((LibroImpreso) libro).prestar(cantidad);
                } else if (tipo.equals("digital")) {
                    ((LibroDigital) libro).prestar(cantidad);
                }
                break;
            case 2:
                if (tipo.equals("impreso")) {
                    ((LibroImpreso) libro).devolver(cantidad);
                } else if (tipo.equals("digital")) {
                    ((LibroDigital) libro).devolver();
                }
                break;
            default:
                System.out.println("Acción no reconocida.");
        }
    }
}
