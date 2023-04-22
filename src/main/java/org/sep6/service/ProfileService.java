package org.sep6.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.sep6.domain.Profile;
import org.sep6.persistence.ProfileRepository;
import org.sep6.service.dto.CreateProfileDto;
import org.sep6.service.dto.ProfileDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository ProfileRepo;

    public ProfileDto createProfile(CreateProfileDto dto) {
        return toDto(ProfileRepo.save(new Profile(dto.name())));
    }

    public List<ProfileDto> getProfiles() {
        return ProfileRepo.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Transactional
    public Optional<ProfileDto> patchProfile(Long id, ProfileDto dto) {
        return ProfileRepo.findById(id)
                .map(m -> patchProfile(m, dto))
                .map(this::toDto);
    }

    private ProfileDto toDto(Profile ent) {
        return new ProfileDto(ent.getId(), ent.getName());
    }

    private Profile patchProfile(Profile Profile, ProfileDto dto) {
        if (dto.name() != null) Profile.setName(dto.name());

        return Profile;
    }
}