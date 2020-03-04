package com.example.movieday.repositoy;

import com.example.movieday.domain.Movie;
import com.example.movieday.domain.MoviePackage;
import com.example.movieday.domain.MovieRating;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MoviePackageRepository extends CrudRepository<MoviePackage, String> {


  boolean existsById(String code);

  Iterable<MoviePackage> findAll();
  Iterable<MoviePackage> findAllById(Iterable<String> iterable);
  long count();

  MoviePackage save(MoviePackage moviePackage);

//  List<MoviePackage> saveAll(Iterable<MoviePackage> iterable);
  void deleteByName(String name);


  void delete(MoviePackage moviePackage);
//void deleteAll(Iterable<MoviePackage> iterable);

  void deleteAll();


  Optional<MoviePackage> findById(String id);
  Optional<MoviePackage> findByName(String name);
}
