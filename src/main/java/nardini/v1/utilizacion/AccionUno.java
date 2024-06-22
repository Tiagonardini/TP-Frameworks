package nardini.v1.utilizacion;

import nardini.v1.frameworks.Accion;

public class AccionUno implements Accion {
    @Override
    public void ejecutar() {
        System.out.println("Ejecutando AccionUno...");
    }

    @Override
    public String nombreItemMenu() {
        return "Accion 1";
    }

    @Override
    public String descripcionItemMenu() {
        return "Esto es para traer los twitts de Maradona...";
    }
}