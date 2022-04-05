package vttp2022paf.day12.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022paf.day12.models.Gif;
import vttp2022paf.day12.service.SearchService;

import org.springframework.ui.Model;

@Controller
@RequestMapping(path="/search")
public class SearchController {
    
    @GetMapping
    public String search(
        @RequestParam(name="phrase") String phrase,
        @RequestParam(name="limit") Integer limit,
        @RequestParam(name="rating") String rating,
        Model model){


            SearchService srcserv = new SearchService();
            List<Gif> gifs = new LinkedList<>();
            gifs = srcserv.search(phrase,limit,rating);
            System.out.printf("RESULT123>>>>>>>>>>>>>>%s",gifs);
            model.addAttribute("gif", gifs);

            return "results";
        

    }

}
