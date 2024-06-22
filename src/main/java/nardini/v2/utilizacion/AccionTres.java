package nardini.v2.utilizacion;

import nardini.v2.frameworks.Accion;

public class AccionTres implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando AccionTres...\n");
    }

    @Override
    public String nombreItemMenu() {
        return "Accion 3\n";
    }

    @Override
    public String descripcionItemMenu() {
        return "Esta es para traer las fotos de Messi con la copa del mundo\n";
    }
}
