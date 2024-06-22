package nardini.v1.frameworks;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConfiguracionFramework {
    private static final String CLASS_NAME_PROPERTY = "accion";
    private static final String CONFIG_FILE_NAME_DEFAULT = "/configuracion.properties";
    Properties properties = new Properties();


    public ConfiguracionFramework( ) throws IOException {
        try (InputStream input = getClass().getResourceAsStream(CONFIG_FILE_NAME_DEFAULT);) {
            properties.load(input);
        } catch (IOException ex) {
            throw new IOException("No se pudo encontrar el archivo de configuración: " + CONFIG_FILE_NAME_DEFAULT);
        }
    }

    public List<String> clases() {
        List<String> clasesAuxiliar = new ArrayList<>();
        String clasesConfig = properties.getProperty(CLASS_NAME_PROPERTY);
        if (clasesConfig != null && !clasesConfig.isEmpty()) {
            String[] clasesArray = clasesConfig.split(";");
            for (String clase : clasesArray) {
                clase = clase.trim();
                if (!clase.isEmpty()) {
                    clasesAuxiliar.add(clase);
                }
            }
        }
        return clasesAuxiliar;
    }
}
