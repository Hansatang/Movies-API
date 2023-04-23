package org.sep6.domain;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class CrewMember {

	@Embeddable
	@Data
	@NoArgsConstructor
	static class CrewMemberId implements Serializable {
		private Long movieId;
		private String role;
		private Long personId;
	}

	@EmbeddedId
	private CrewMemberId id;

	@ManyToOne
	@MapsId("movieId")
	private Movie movie;

	@ManyToOne
	@MapsId("role")
	private MemberRole role;

	@ManyToOne
	@MapsId("personId")
	private Profile person;
}