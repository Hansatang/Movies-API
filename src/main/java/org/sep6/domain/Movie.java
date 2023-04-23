package org.sep6.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private Year year;

	@OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	private List<CrewMember> crew;

	public Movie(String title, Year year) {
		this.title = title;
		this.year = year;
	}
}
