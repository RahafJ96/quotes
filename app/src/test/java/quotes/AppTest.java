/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void testJsonReader() throws FileNotFoundException {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\AB\\401course\\quotes\\app\\src\\test\\java\\quotes\\recentquotes.json"));
        assertNotNull("testJsonReader should return: ",String.valueOf(reader)
        );
    }
    @Test
    public void testConstructorQuote(){
        Quotes quot = new Quotes(null, "Lennon", "infinite likes","All monsters are human");
        assertEquals(null, quot.getTags());
        assertEquals("Lennon", quot.getAuthor());
        assertEquals("infinite likes", quot.getLIKES());
        assertEquals("All monsters are human", quot.getText());

    }

    @Test
    public void testRandomQuote() throws FileNotFoundException {
        Gson gson = new Gson();
        int idx =0;
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\AB\\401course\\quotes\\app\\src\\test\\java\\quotes\\recentquotes.json"));
        List<Quotes> quote = gson.fromJson(reader, new TypeToken<List<Quotes>>() {}.getType());
        int min = 0;
        int max = quote.size()-1 ;
        Quotes quote1 = quote.get((int) (Math.random()*(max- min+1)+ min));
        for(int i = 0; i < quote.size(); i++) {
            if(quote.get(i).getText().equals(quote1.getText())){
                idx = i;
            }
        }
        assertTrue(idx < quote.size()-1, "return true if successfully got a random quote from the json file ");
    }

    @Test
    public void testAPI() throws IOException {
        URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        assertEquals(200, connection.getResponseCode(), String.valueOf(true));
    }
}



