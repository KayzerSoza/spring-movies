package com.example.movieday;

import com.example.movieday.domain.Language;
import com.example.movieday.domain.Region;
import com.example.movieday.service.MoviePackageService;
import com.example.movieday.service.MovieService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.PropertyAccessor.FIELD;

@SpringBootApplication
public class MovieDayApplication implements CommandLineRunner {
  @Value("movies.json")
  private String importFile;

  @Autowired
  private MoviePackageService moviePackageService;
  @Autowired
  private MovieService movieService;


  public static void main(String[] args) {
    SpringApplication.run(MovieDayApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    createMoviePackages();
    createMovies(importFile);
  }

  private void createMoviePackages(){
    moviePackageService.createMoviePackage("RM", "Recent Movies");
    moviePackageService.createMoviePackage("MM", "Movies of the new Millennium");
    moviePackageService.createMoviePackage("90", "Nostalgia: The 90s");
    moviePackageService.createMoviePackage("80", "Nostalgia: The 80s");

  }


  private void createMovies(String fileToImport) throws IOException {
    MovieFromFile.read(fileToImport).forEach(movieEntry ->
            movieService.createMovie(
                    movieEntry.getTitle(),
                    movieEntry.getDirector(),
                    movieEntry.getStars(),
                    movieEntry.getDescription(),
                    movieEntry.getYear(),
                    movieEntry.getDuration(),
                    movieEntry.getPrice(),
                    movieEntry.getGenre(),
                    movieEntry.getPackageType(),
                    movieEntry.getLanguage(),
                    movieEntry.getRegion()
                   ));
  }

  private static class MovieFromFile {

    private String packageType, title, director, stars, price, duration,
            description, genre, language, region, year;

    static List<MovieFromFile> read(String fileToImport) throws IOException {
      return new ObjectMapper().setVisibility(FIELD, ANY).
              readValue(new FileInputStream(fileToImport), new TypeReference<>() {});
    }

   protected MovieFromFile(){

    }

    String getPackageType() {
      return packageType;
    }

     String getTitle() {
      return title;
    }

    String getDirector() {
      return director;
    }

    String getStars() {
      return stars;
    }

    Integer getPrice() {
      return Integer.parseInt(price);
    }

     String getDuration() {
      return duration;
    }

   String getDescription() {
      return description;
    }

   String getGenre() {
      return genre;
    }

    Language getLanguage() {
      return Language.valueOf(language);
    }

    Region getRegion() {
     return Region.findByLabel(region) ;
    }
    String getYear() {
      return year;
    }
  }
}
