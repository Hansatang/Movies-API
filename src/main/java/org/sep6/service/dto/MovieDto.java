package org.sep6.service.dto;

import java.time.Year;

public record MovieDto(
		long id,
		String title,
		Year year
) {}
