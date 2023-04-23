package org.sep6.domain;

import java.time.Year;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

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
