/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class AppTest {

    @Test
    @DisplayName("Testing The Code")
    public void testConverter() throws FileNotFoundException {

        Gson gson = new Gson();
        Reader reader = new FileReader("C:\\Users\\AB\\401course\\quotes\\app\\src\\main\\java\\quotes\\recentquotes.json");


        Type listType = new TypeToken<ArrayList<Quotes>>() {
        }.getType();


        List<Quotes> qoutesList = gson.fromJson(reader, listType);


        Random random = new Random();
        int books = random.nextInt(qoutesList.size());
        String randomBook = qoutesList.get(books).toString();

        assertEquals(randomBook, qoutesList.get(books).toString());
    }
}
