package com.karatesan.movies.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karatesan.movies.Review;
import com.karatesan.movies.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ReviewController {
	
	private final ReviewService service;
	
	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload)
	{
		return ResponseEntity.ok(service.createReview(payload.get("reviewBody"), payload.get("imdbId")));
	}
	

}
