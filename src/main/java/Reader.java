import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    public static JSONObject readData(InputStreamReader in) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(in);
        StringBuilder sb = new StringBuilder();
        // adding opening bracket to make it look like JSON
        sb.append("{");
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        sb.append("}");
        // adding closing bracket to make it look like JSON
        JSONObject json = new JSONObject(sb.toString());
        bufferedReader.close();
        return json;
    }

}
