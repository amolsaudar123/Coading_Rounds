package fiserv;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        URL obj = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JsonElement jsonElement = new JsonParser().parse(response.toString());

        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement test = jsonObject.get("data");
        JsonArray arr = test.getAsJsonArray();
        List<String> titles = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {

            JsonElement temp = arr.get(i);
            JsonObject temp3 = temp.getAsJsonObject();

            titles.add(temp3.get("Title").toString());


        }
        Collections.sort(titles);
        titles.forEach(it -> System.out.println(it));
    }
}
