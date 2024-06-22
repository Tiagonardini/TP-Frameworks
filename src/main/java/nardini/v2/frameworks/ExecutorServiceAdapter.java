package nardini.v2.frameworks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceAdapter {
    private final ExecutorService executorService;

    public ExecutorServiceAdapter(int maxThreads) {
        this.executorService = Executors.newFixedThreadPool(maxThreads);
    }

    public void submit(Accion accion) {
        executorService.submit(new AccionRunnable(accion));
    }

    public void shutdown() {
        try {
            executorService.shutdown();
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
