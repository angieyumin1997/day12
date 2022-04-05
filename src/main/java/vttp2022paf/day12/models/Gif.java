package vttp2022paf.day12.models;

import jakarta.json.JsonObject;

public class Gif {
    private String name;
    private String image;

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    

    public static Gif create(JsonObject o){
        Gif gif = new Gif();
        gif.name = o.getString("title");
        
        o = o.getJsonObject("images");
        o = o.getJsonObject("fixed_height");
        gif.image = o.getString("url");

        return gif;


    }

}
