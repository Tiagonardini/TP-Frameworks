package nardini.v2.utilizacion;

import nardini.v2.frameworks.Accion;

public class AccionUno implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando AccionUno...\n");
    }

    @Override
    public String nombreItemMenu() {
        return "Accion 1\n";
    }

    @Override
    public String descripcionItemMenu() {
        return "Esto es para traer los twitts de Maradona...\n";
    }
}
