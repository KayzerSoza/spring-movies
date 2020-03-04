package com.example.movieday.repositoy;

import com.example.movieday.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie, Integer> {



  Optional <Movie> findById(Integer id);
  Iterable<Movie> findAll();
  long count();

  Movie save(Movie movie);

  void deleteById(Integer id);
  void delete (Movie movie);

  void deleteAll();
}
