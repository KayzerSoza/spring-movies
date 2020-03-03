package com.example.movieday.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Movie {

  @Id
  @GeneratedValue
  private Integer id;

  @Column
  private String title;


  @Column
  private String director;

  @Column
  private String stars;

  @Column(length = 2000)
  private String description;

  @Column
  private String year;

  @Column
  private String duration;

  @Column
  private Integer price;

  @Column
  private String genre;

  @ManyToOne
  private MoviePackage moviePackage;

  @Column
  @Enumerated
  private Language language;

  @Column
  @Enumerated
  private Region region;



  public Movie(String title, String director, String stars, String description, String year, String duration,
               Integer price, String genre, MoviePackage moviePackage, Language language, Region region) {
    this.title = title;
    this.director = director;
    this.stars = stars;
    this.description = description;
    this.year = year;
    this.duration = duration;
    this.price = price;
    this.genre = genre;
    this.moviePackage = moviePackage;
    this.language = language;
    this.region = region;
  }

  protected Movie() {
  }

  public Integer getId() {
    return id;
  }



  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getStars() {
    return stars;
  }

  public void setStars(String stars) {
    this.stars = stars;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public MoviePackage getMoviePackage() {
    return moviePackage;
  }

  public void setMoviePackage(MoviePackage moviePackage) {
    this.moviePackage = moviePackage;
  }

  public Language getLanguage() {
    return language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public Region getRegion() {
    return region;
  }

  public void setRegion(Region region) {
    this.region = region;
  }


  @Override
  public String toString() {
    return "Movie{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", director='" + director + '\'' +
            ", stars='" + stars + '\'' +
            ", description='" + description + '\'' +
            ", year='" + year + '\'' +
            ", duration='" + duration + '\'' +
            ", price=" + price +
            ", genre='" + genre + '\'' +
            ", moviePackage=" + moviePackage +
            ", language=" + language +
            ", region=" + region +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Movie)) return false;
    Movie movie = (Movie) o;
    return Objects.equals(id, movie.id) &&
            Objects.equals(title, movie.title) &&
            Objects.equals(director, movie.director) &&
            Objects.equals(stars, movie.stars) &&
            Objects.equals(description, movie.description) &&
            Objects.equals(year, movie.year) &&
            Objects.equals(duration, movie.duration) &&
            Objects.equals(price, movie.price) &&
            Objects.equals(genre, movie.genre) &&
            Objects.equals(moviePackage, movie.moviePackage) &&
            language == movie.language &&
            region == movie.region;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, director, stars, description, year, duration, price, genre, moviePackage, language, region);
  }
}
