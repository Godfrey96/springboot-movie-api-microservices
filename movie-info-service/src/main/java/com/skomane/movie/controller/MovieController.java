package com.skomane.movie.controller;

import com.skomane.movie.model.Movie;
import com.skomane.movie.service.MovieInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
//@RequiredArgsConstructor
public class MovieController {

    @Autowired
    private MovieInfoService movieInfoService;

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieDetails(@PathVariable String movieId){
        return new ResponseEntity<>(movieInfoService.getMoviesDetails(movieId), HttpStatus.OK);
    }

}
