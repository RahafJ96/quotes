/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\AB\\401course\\quotes\\app\\src\\main\\java\\quotes\\recentquotes.json"));
        List<Quotes> quote = gson.fromJson(reader, new TypeToken<List<Quotes>>() {}.getType());
        reader.close();

        int min = 0;
        int max = quote.size()-1 ;

        try{
            URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            BufferedWriter add = new BufferedWriter(new FileWriter("C:\\Users\\Motas\\asac\\401\\quotes\\app\\src\\main\\java\\quotes\\recentqoutes.json" , false));
            ApiQuote qutApi = gson.fromJson(bufferedReader,ApiQuote.class);
            Quotes quotLocal = new Quotes(null, qutApi.getAuthor(), null,qutApi.getQuote());
            quote.add(quotLocal);
            gson = gson.newBuilder().setPrettyPrinting().create();


            System.out.println("Quote from API: "+quotLocal);
            add.write(gson.toJson(quote));
            add.close();

            bufferedReader.close();

        }catch (Exception e){
            System.out.println(quote.get((int) (Math.random()*(max- min+1)+ min)).toString());
        }

    }


}

