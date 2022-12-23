package com.skomane.movie.service.impl;

import com.skomane.movie.model.CatalogItem;
import com.skomane.movie.model.Movie;
import com.skomane.movie.service.MovieCatalogService;
import com.skomane.ratingsdataservice.model.UserRating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieCatalogServiceImpl implements MovieCatalogService {

    private final WebClient.Builder webClientBuilder;

    @Override
    public List<CatalogItem> getCatalog(String userId) {

        UserRating userRating = webClientBuilder.build()
                .get()
                .uri("http://ratings-data-service/api/v1/ratings/users/" + userId)
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();

        return userRating.getRatings().stream().map(rating -> {

            Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://movie-info-service/api/v1/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

            return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
        }).collect(Collectors.toList());

    }
}
