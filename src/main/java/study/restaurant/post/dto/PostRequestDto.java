package study.restaurant.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import study.restaurant.post.domain.Address;
import study.restaurant.post.domain.Place;
import study.restaurant.post.domain.Post;
import study.restaurant.post.domain.Rate;


@Getter
 public class PostRequestDto { // 서버가 클라이언트에게 받아야 하는 정보

    private Long userId;

    private String placeName;

    @NotBlank(message = "가게 이름 정보는 필수 입니다")
    private String restaurant;

    private Address address;

    @Size(max = 150)
    private String comment;


    private Rate rate;

    private int score;


    public Post toEntity(){
        return Post.builder()
                .restaurant(restaurant)
                .address(address)
                .comment(comment)
                .rate(rate)
                .score(score)
                .build();
    }
}
