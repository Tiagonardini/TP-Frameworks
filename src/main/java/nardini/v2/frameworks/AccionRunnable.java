package nardini.v2.frameworks;

public class AccionRunnable implements Runnable {
    private final Accion accion;

    public AccionRunnable(Accion accion) {
        this.accion = accion;
    }

    @Override
    public void run() {
        try {
            accion.ejecutar();
            System.out.println("Acción ejecutada exitosamente: " + accion.nombreItemMenu());
        } catch (Exception e) {
            System.out.println("Error al ejecutar la acción: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
