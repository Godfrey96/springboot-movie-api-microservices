package com.skomane.movie.service;

import com.skomane.movie.model.Movie;

public interface MovieInfoService {
    Movie getMoviesDetails(String movieId);
}
