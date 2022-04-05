package vttp2022paf.day12.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import vttp2022paf.day12.models.Gif;
import vttp2022paf.day12.models.GifUtility;

@Service
public class SearchService {
    
    // @Value("${giphy.api.key}")
    // private String giphyKey;

    // private boolean hasKey;

    // @PostConstruct
    // private void init() {
    //     hasKey = null != giphyKey;
    //     System.out.println(">>>> API key set: " + hasKey);
    // }

    // public List<String> getGiphs(String q){
    //     return getGiphs(q,"pg",10);
    // }

    // public List<String> getGiphs(String q,String rating){
    //     return getGiphs(q,rating,10);
    // }

    // public List<String> getGiphs(String q,Integer limit){
    //     return getGiphs(q,"pg",limit);
    // }

    // public List<String> getGiphs(String q,String rating,Integer limit){
    //     return null;
    // }

    private static final String URL = "https://api.giphy.com/v1/gifs/search";

    public List<Gif> search(String phrase,Integer limit,String rating){
        
        String getGifResults = UriComponentsBuilder.fromUriString(URL)
        .queryParam("api_key", "sS5wmmc9AfRvdyAg5l8Sa8HBpY48ciXS")
        .queryParam("q", phrase)
        .queryParam("limit",limit)
        .queryParam("rating",rating)
        .queryParam("offset", 0)
        .queryParam("lang", "en")
        .toUriString();

    System.out.printf(">>> website: %s", getGifResults);

    RestTemplate template = new RestTemplate();
    ResponseEntity<String> resp = template.getForEntity(getGifResults, String.class);
    return GifUtility.create(resp.getBody()).getGif();
    }
}
