package org.sep6.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
public class CrewMember {

    @Data
    @NoArgsConstructor
    static class CrewMemberId implements Serializable {
        private Long movieId;
        private String role;
        private Long personId;
    }

    @Id
    private CrewMemberId id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private MemberRole role;

    @ManyToOne
    private Profile person;
}