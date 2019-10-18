import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {
    @Test
    void readData() throws IOException {
        String str = "o: {a:b, c:d}";
        JSONObject json = Reader.readData(new InputStreamReader(new ByteArrayInputStream(str.getBytes())));
        assertEquals("b", json.getJSONObject("o").get("a"));
        assertEquals("d", json.getJSONObject("o").get("c"));
    }

    @Test
    void readDataWrongFormat() {
        String str = "o {a:b, c:d}";
        assertThrows(JSONException.class, () -> Reader.readData(new InputStreamReader(new ByteArrayInputStream(str.getBytes()))));
    }

    @Test
    void readDataFromConsole() throws IOException {
        String str = "o: {a:b, c:d}";
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
        System.setIn(bais);
        JSONObject json = Reader.readData(new InputStreamReader(System.in));
        bais.close();
    }
}
