package uniqram.c1one.profile.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uniqram.c1one.profile.dto.ProfileResponseDto;
import uniqram.c1one.profile.dto.ProfileUpdateRequestDto;
import uniqram.c1one.profile.service.ProfileService;
import uniqram.c1one.security.adapter.CustomUserDetails;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/profiles/{userId}")
    public ProfileResponseDto getProfile(@PathVariable Long userId) {
        return profileService.getProfileById(userId);
    }


    @PatchMapping("/profiles")
    public ProfileResponseDto patchProfile(
            @Valid @RequestBody ProfileUpdateRequestDto profileUpdateRequestDto,
            @AuthenticationPrincipal CustomUserDetails userDetails
    ) {
        return profileService.updateProfile(userDetails.getUserId(), profileUpdateRequestDto);
    }
}
