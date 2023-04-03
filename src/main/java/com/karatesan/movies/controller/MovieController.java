package com.karatesan.movies.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karatesan.movies.Movie;
import com.karatesan.movies.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {
	
	private MovieService service;
	
	@Autowired
	public MovieController(MovieService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Movie>> GetAllMovies() {
		return ResponseEntity.ok(service.allMovies());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
		
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping("/imdb/{imdbId}")
	public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId){
		
		return ResponseEntity.ok(service.findByImdbId(imdbId));
	}
	

}
