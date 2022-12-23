package com.skomane.ratingsdataservice.service.impl;

import com.skomane.ratingsdataservice.model.Rating;
import com.skomane.ratingsdataservice.model.UserRating;
import com.skomane.ratingsdataservice.service.RatingsService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RatingsServiceImpl implements RatingsService {
    @Override
    public Rating getRatings(String movieId) {
        return new Rating(movieId, 5);
    }

    @Override
    public UserRating getUserRating(String userId) {

        List<Rating> ratings = Arrays.asList(
                new Rating("100", 7),
                new Rating("200", 3)
        );
        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);
        return userRating;
    }
}
