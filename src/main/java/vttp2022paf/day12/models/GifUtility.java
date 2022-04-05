package vttp2022paf.day12.models;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class GifUtility {

    private List<Gif> gif;

    public List<Gif> getGif() {
        return gif;
    }

    public void setGif(List<Gif> gif) {
        this.gif = gif;
    }

    public static GifUtility create(String json){
        GifUtility g = new GifUtility();

        InputStream is = new ByteArrayInputStream(json.getBytes());
        JsonReader r = Json.createReader(is);
        JsonObject o = r.readObject();

        JsonArray a = o.getJsonArray("data");
        List <Gif> gif = new LinkedList<>();

        for (int i = 0; i < a.size();i++){

            gif.add(Gif.create(a.getJsonObject(i)));
        }

        g.gif = gif;
        return g;

    }
    
    
}
