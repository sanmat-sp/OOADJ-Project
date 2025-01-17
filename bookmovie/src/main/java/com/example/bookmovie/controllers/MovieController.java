package com.example.bookmovie.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookmovie.models.Movie;
import com.example.bookmovie.service.MovieService;

@RestController
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/allMovies")
    public List<Movie> getAll() {
        return movieService.getMovies();
    }

    @PostMapping("/movies")
    public String addMovie(@RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("genre") String genre,
            @RequestParam("durationMins") Integer durationMins,
            @RequestParam("releaseDate") String releaseDate,
            @RequestParam("description") String description) {
        System.out.println("/movies route");
        System.out.println(file);
        movieService.addMovie(name, genre, durationMins, releaseDate, description, file);
        return "redirect:/Home";
    }

    @GetMapping("/movies/{movieId}")
    public Movie getById(@PathVariable Integer movieId) {
        return movieService.getMovieById(movieId);
    }

}
