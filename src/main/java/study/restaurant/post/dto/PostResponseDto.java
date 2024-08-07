package study.restaurant.post.dto;

import lombok.Builder;
import lombok.Getter;
import study.restaurant.post.domain.Address;
import study.restaurant.post.domain.Place;
import study.restaurant.post.domain.Post;
import study.restaurant.post.domain.Rate;

@Getter
@Builder
public class PostResponseDto { // 엔티티를 dto로 변환하여(엔티티에 있는 데이터를 추출하여) 클라이언트에게 전달하는 dto

    private Long id;
    private PlaceDto place;
    private String restaurant;
    private Address address;
    private String comment;
    private Rate rate;
    private int score;
    private int postNumber;

    public static PostResponseDto fromEntity(Post post) {
        return PostResponseDto.builder()
                .id(post.getId())
                .place(PlaceDto.fromEntity(post.getPlace())) //place 객체를 dto로 반환
                .restaurant(post.getRestaurant())
                .address(post.getAddress())
                .comment(post.getComment())
                .rate(post.getRate())
                .score(post.getScore())
                .postNumber(post.getPostNumber())
                .build();
    }
    // 객체 인스턴스를 필요로 하지 않기 때문에 static 메서드(정적 메서드)를 선언한다.
    // user객체를 받게 되면 지연로딩할 때 프록시를 사용해서 api요청을 보내면 응답에 실패한다.
}
