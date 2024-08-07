package study.restaurant.user.dto;

import lombok.Builder;
import lombok.Getter;
import study.restaurant.user.domain.User;

@Getter
@Builder
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;

    public static UserResponseDto fromEntity(User user) {
      return   UserResponseDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

}
