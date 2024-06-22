package nardini.v2.frameworks;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Accion> acciones = new ArrayList<>();
    private ExecutorServiceAdapter adapterExecutor;
    private ConfiguracionFramework configuracion;

    public Menu() throws IOException {
        configuracion = new ConfiguracionFramework();
        cargarAcciones();
        adapterExecutor = new ExecutorServiceAdapter(configuracion.cualEsElMaxThreads());
    }

    private void cargarAcciones() throws IOException {
        List<String> clasesAcciones = configuracion.clases();
        for (String clase : clasesAcciones) {
            try {
                Class<?> clazz = Class.forName(clase);
                Accion accion = (Accion) clazz.getDeclaredConstructor().newInstance();
                acciones.add(accion);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException e) {
                throw new RuntimeException("Error al cargar la clase: " + clase, e);
            }
        }
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            mostrarMenu();
            int opcion = leerOpcionUsuario(scanner);
            if (opcion == 0) {
                System.out.println("Saliendo...");
                adapterExecutor.shutdown();
                break;
            } else if (opcion == acciones.size() + 1) {
                ejecutarTodasAcciones();
            } else if (opcion > 0 && opcion <= acciones.size()) {
                Accion accion = acciones.get(opcion - 1);
                adapterExecutor.submit(accion);
            } else {
                System.out.println("Opción no válida, intente nuevamente.");
            }
        }
    }

    private void ejecutarTodasAcciones() {
        for (Accion accion : acciones) {
            adapterExecutor.submit(accion);
        }
        System.out.println("Todas las acciones han sido enviadas para ejecución.\n");
    }

    private int leerOpcionUsuario(Scanner scanner) {
        System.out.print("Seleccione una opción: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void mostrarMenu() {
        System.out.println("\nMenú de opciones:\n");

        for (int i = 0; i < acciones.size(); i++) {
            Accion accion = acciones.get(i);
            System.out.println((i + 1) + ". " + accion.nombreItemMenu() + " - " + accion.descripcionItemMenu());
        }
        System.out.println((acciones.size() + 1) + ". Ejecutar todas las acciones\n");
        System.out.println("0. Salir\n");
    }
}
