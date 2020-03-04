package com.example.movieday.service;

import com.example.movieday.domain.MoviePackage;
import com.example.movieday.repositoy.MoviePackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviePackageService {

  private MoviePackageRepository moviePackageRepository;

  @Autowired
  public MoviePackageService(MoviePackageRepository moviePackageRepository) {
    this.moviePackageRepository = moviePackageRepository;
  }


  public MoviePackage createMoviePackage(String code, String name) {
    return moviePackageRepository
    .findById(code)
    .orElse(moviePackageRepository.save(new MoviePackage(code, name)));
  }

  public Iterable<MoviePackage> lookup(){
    return moviePackageRepository.findAll();
  }

  public long total() {
    return moviePackageRepository.count();
  }
}



