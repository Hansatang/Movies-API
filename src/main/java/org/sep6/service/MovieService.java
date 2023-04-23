package org.sep6.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sep6.domain.Movie;
import org.sep6.persistence.MovieRepository;
import org.sep6.service.dto.CreateMovieDto;
import org.sep6.service.dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieRepository movieRepo;

	public MovieDto createMovie(CreateMovieDto dto) {
		return toDto(movieRepo.save(new Movie(dto.title(), dto.year())));
	}

	public List<MovieDto> getMovies() {
		return movieRepo.findAll()
			.stream()
			.map(this::toDto)
			.toList();
	}

	@Transactional
	public Optional<MovieDto> patchMovie(Long id, MovieDto dto) {
		return movieRepo.findById(id)
			.map(m -> patchMovie(m, dto))
			.map(this::toDto);
	}

	private MovieDto toDto(Movie ent) {
		return new MovieDto(ent.getId(), ent.getTitle(), ent.getYear());
	}

	private Movie patchMovie(Movie movie, MovieDto dto) {
		if(dto.title() != null) movie.setTitle(dto.title());
		if(dto.year() != null) movie.setYear(dto.year());
		return movie;
	}
}
