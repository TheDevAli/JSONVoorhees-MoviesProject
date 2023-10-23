package com.sparta.jsonvoorhees.springapi.controller;

import com.sparta.jsonvoorhees.springapi.service.VoorheesWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    private final VoorheesWebService voorheesWebService;

    public WebController(VoorheesWebService voorheesWebService) {
        this.voorheesWebService = voorheesWebService;
    }

    @GetMapping("/web/movies")
    public String getAllMovies(Model model, @RequestParam(name = "title", required = false) String title) {
        model.addAttribute("movies", voorheesWebService.getAllMoviesWithTitle(title));
        return "movies";
    }
}
