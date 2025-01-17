package com.example.bookmovie.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookmovie.models.Theatre;
import com.example.bookmovie.service.TheatreService;

@RestController
public class TheatreController {
    
    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService){
        this.theatreService = theatreService;
    }

    @GetMapping("/theatres")
    public List<Theatre> getAll(){
        return theatreService.getTheatres();
    }

    @PostMapping("/theatres")
    public Theatre addTheatre(@RequestBody Theatre theatre){
        return theatreService.addTheatre(theatre);
    }

    @GetMapping("/theatres/{name}")
    public Theatre getById(@PathVariable Integer theatreId){
        return theatreService.getTheatreById(theatreId);
    }
}
