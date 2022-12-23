package com.skomane.movie.controller;

import com.skomane.movie.model.CatalogItem;
import com.skomane.movie.service.MovieCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieCatalogController {

    private final MovieCatalogService movieCatalogService;

    @GetMapping("/catalog/{userId}")
    public ResponseEntity<List<CatalogItem>> getCatalog(@PathVariable String userId){
        return new ResponseEntity<>(movieCatalogService.getCatalog(userId), HttpStatus.OK);
    }

}
