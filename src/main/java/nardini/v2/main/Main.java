package nardini.v2.main;

import nardini.v2.frameworks.Menu;

public class Main {
    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            menu.iniciar();
        } catch (Exception e) {
            System.out.println("Error al cargar la configuración: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
