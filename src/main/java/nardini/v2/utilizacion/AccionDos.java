package nardini.v2.utilizacion;

import nardini.v2.frameworks.Accion;

public class AccionDos implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando AccionDos...\n");
    }

    @Override
    public String nombreItemMenu() {
        return "Accion 2\n";
    }

    @Override
    public String descripcionItemMenu() {
        return "Esto trae las primeras diez personas de la BD...\n";
    }
}
