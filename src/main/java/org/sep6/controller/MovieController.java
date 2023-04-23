package org.sep6.controller;

import java.util.List;

import org.sep6.service.MovieService;
import org.sep6.service.dto.CreateMovieDto;
import org.sep6.service.dto.MovieDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

	private final MovieService movieService;

// 	@PostMapping
// 	public ResponseEntity<MovieDto> createMovieButWorse(CreateMovieDto dto) {
// 		return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(dto));
// 	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MovieDto createMovie(@RequestBody CreateMovieDto dto) {
		return movieService.createMovie(dto);
	}

	@GetMapping
	public List<MovieDto> getMovies() {
		return movieService.getMovies();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<MovieDto> patchMovie(@PathVariable Long id, @RequestBody MovieDto dto) {
		return ResponseEntity.of(movieService.patchMovie(id, dto));
	}
}