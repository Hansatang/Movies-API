package org.sep6.controller;

import lombok.RequiredArgsConstructor;
import org.sep6.service.MovieService;
import org.sep6.service.dto.CreateMovieDto;
import org.sep6.service.dto.MovieDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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