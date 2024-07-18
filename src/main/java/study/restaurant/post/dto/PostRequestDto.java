package study.restaurant.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import study.restaurant.post.domain.Address;
import study.restaurant.post.domain.Place;
import study.restaurant.post.domain.Post;
import study.restaurant.post.domain.Rate;


@Getter
 public class PostRequestDto {

    private Long userId;

    private Place place;

    @NotBlank(message = "가게 이름 정보는 필수 입니다")
    private String placeName;

    private Address address;

    @Size(max = 150)
    private String comment;


    private Rate rate;

    private int score;


    public Post toEntity(){
        return Post.builder()
                .place(place)
                .placeName(placeName)
                .address(address)
                .comment(comment)
                .rate(rate)
                .score(score)
                .build();
    }
}
