package com.skomane.movie.service.impl;

import com.skomane.movie.model.Movie;
import com.skomane.movie.model.MovieDetails;
import com.skomane.movie.service.MovieInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class MovieInfoServiceImpl implements MovieInfoService {

    @Value("${api.key}")
    private String apiKey;
    private final WebClient.Builder webClientBuilder;

    @Override
    public Movie getMoviesDetails(String movieId) {

        MovieDetails movieDetails = webClientBuilder.build()
                .get()
                .uri("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey)
                .retrieve()
                .bodyToMono(MovieDetails.class)
                .block();

        return new Movie(movieId, movieDetails.getTitle(), movieDetails.getDetails());
    }
}
