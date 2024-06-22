package nardini.v1.main;

import nardini.v1.frameworks.Menu;

public class Main {
    public static void main(String[] args) {
        try {
            Menu menuframework = new Menu();
            menuframework.iniciar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
