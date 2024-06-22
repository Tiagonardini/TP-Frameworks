package nardini.v2.frameworks;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ConfiguracionFramework {
    private static final String CONFIG_FILE_NAME_DEFAULT = "/json.properties";
    private List<String> clases = new ArrayList<>();
    private int maxThreads = 1;

    public ConfiguracionFramework() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(CONFIG_FILE_NAME_DEFAULT);
        if (inputStream == null) {
            throw new IOException("No se encontró el archivo de configuración: " + CONFIG_FILE_NAME_DEFAULT);
        }
        InputStreamReader reader = new InputStreamReader(inputStream);
        JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        jsonObject.getAsJsonArray("acciones").forEach(jsonElement -> clases.add(jsonElement.getAsString()));
        maxThreads = jsonObject.get("max-threads").getAsInt();
    }

    public List<String> clases() {
        return clases;
    }

    public int cualEsElMaxThreads(){
        if (maxThreads == -1){
            throw new RuntimeException("No se definio MaxThreads");
        }
        return maxThreads;
    }
}
