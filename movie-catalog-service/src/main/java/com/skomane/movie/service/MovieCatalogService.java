package com.skomane.movie.service;

import com.skomane.movie.model.CatalogItem;

import java.util.List;

public interface MovieCatalogService {
    List<CatalogItem> getCatalog(String userId);
}
