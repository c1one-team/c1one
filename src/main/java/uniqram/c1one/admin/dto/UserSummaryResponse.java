package uniqram.c1one.admin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import uniqram.c1one.user.entity.Users;
import uniqram.c1one.redis.model.ActiveUser;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class UserSummaryResponse {
    private Long id;
    private String username;
    private String role;

    public static UserSummaryResponse from(Users user) {
        return UserSummaryResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole().name())
                .build();
    }

    public static UserSummaryResponse from(ActiveUser user) {
        return UserSummaryResponse.builder()
                .id(user.getUserId())
                .username(user.getUsername())
                .build();
    }
}
