package com.karatesan.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Service;

import com.karatesan.movies.Movie;
import com.karatesan.movies.Review;
import com.karatesan.movies.repository.ReviewRepository;

@Service
public class ReviewService {
	
	private ReviewRepository repo;
	private MongoTemplate mongoTemplate;
	
	@Autowired
	public ReviewService(ReviewRepository repo, MongoTemplate mongoTemplate) {
		this.repo = repo;
		this.mongoTemplate = mongoTemplate;
	}

	public Review createReview(String reviewBody, String imbdId) {
		
		Review review = repo.insert(new Review(reviewBody));	
		
		mongoTemplate.update(Movie.class)
				.matching(Criteria.where("imdbId").is(imbdId))
				.apply(new Update().push("reviewIds").value(review))
				.first();
		
		return review;
						
	}
}
