package com.skomane.ratingsdataservice.controller;

import com.skomane.ratingsdataservice.model.Rating;
import com.skomane.ratingsdataservice.model.UserRating;
import com.skomane.ratingsdataservice.service.RatingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/ratings")
@RequiredArgsConstructor
public class RatingsController {

    private final RatingsService ratingsService;

    @GetMapping("/{movieId}")
    public ResponseEntity<Rating> getRatings(@PathVariable String movieId){
        return new ResponseEntity<>(ratingsService.getRatings(movieId), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserRating> getUserRating(@PathVariable String userId){
        return new ResponseEntity<>(ratingsService.getUserRating(userId), HttpStatus.OK);
    }

}
