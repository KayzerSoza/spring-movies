package com.example.movieday.service;

import com.example.movieday.domain.Language;
import com.example.movieday.domain.Movie;
import com.example.movieday.domain.MoviePackage;
import com.example.movieday.domain.Region;
import com.example.movieday.repositoy.MoviePackageRepository;
import com.example.movieday.repositoy.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  private MovieRepository movieRepository;
  private MoviePackageRepository moviePackageRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository, MoviePackageRepository moviePackageRepository) {
    this.movieRepository = movieRepository;
    this.moviePackageRepository = moviePackageRepository;
  }

  public Movie createMovie(String title,
                           String director,
                           String stars,
                           String description,
                           String year,
                           String duration,
                           Integer price,
                           String genre,
                           String moviePackageName,
                           Language language,
                           Region region ) {
    MoviePackage moviePackage=moviePackageRepository
            .findByName(moviePackageName)
            .orElseThrow(()-> new RuntimeException("There is no movie package named :" + moviePackageName));
    return movieRepository.save(new Movie(title,  director,  stars,  description, year, duration,
          price,  genre, moviePackage, language, region));

  }

  public long total() {
    return movieRepository.count();
  }


}
