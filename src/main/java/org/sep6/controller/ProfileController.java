package org.sep6.controller;

import java.util.List;

import org.sep6.service.ProfileService;
import org.sep6.service.dto.CreateProfileDto;
import org.sep6.service.dto.ProfileDto;
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
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController {

	private final ProfileService profileService;


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProfileDto createProfile(@RequestBody CreateProfileDto dto) {
		return profileService.createProfile(dto);
	}

	@GetMapping
	public List<ProfileDto> getProfiles() {
		return profileService.getProfiles();
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ProfileDto> patchMovie(@PathVariable Long id, @RequestBody ProfileDto dto) {
		return ResponseEntity.of(profileService.patchProfile(id, dto));
	}
}
