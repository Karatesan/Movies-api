package com.karatesan.movies.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karatesan.movies.Movie;
import com.karatesan.movies.repository.MovieRepository;
import com.mongodb.client.model.ReturnDocument;

@Service
public class MovieService {
	
	private MovieRepository repo;
	
	@Autowired
	public MovieService(MovieRepository repo) {
		this.repo = repo;
	}
	
	public List<Movie> allMovies(){	
		return repo.findAll();
	}

	public Optional<Movie> findById(ObjectId id) {
		
		return repo.findById(id);
	}

	public Optional<Movie> findByImdbId(String imdbId) {
			return repo.findMovieByImdbId(imdbId);
	}

}
