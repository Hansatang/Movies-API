package org.sep6.service.dto;

import java.time.Year;

public record CreateMovieDto(
		String title,
		Year year
) {}