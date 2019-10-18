import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {
    public static JSONObject readData(InputStreamReader in) throws IOException {
        return stringToJson(readString(in));
    }

    private static String readString(InputStreamReader in) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(in)) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }
    }

    private static JSONObject stringToJson(String string) {
        return new JSONObject(string.trim().charAt(0) != '{' ? "{" + string + "}" : string);
    }
}
