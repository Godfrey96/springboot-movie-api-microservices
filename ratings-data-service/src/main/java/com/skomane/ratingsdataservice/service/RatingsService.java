package com.skomane.ratingsdataservice.service;

import com.skomane.ratingsdataservice.model.Rating;
import com.skomane.ratingsdataservice.model.UserRating;

public interface RatingsService {
    Rating getRatings(String movieId);
    UserRating getUserRating(String userId);
}
