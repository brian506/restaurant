package study.restaurant.post.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Table(name = "place")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Place {

    @Id @GeneratedValue
    @Column(name = "place_id")
    private Long id;

    @Setter
    private String placeName;

    @JsonIgnore // place 객체가 post객체에 포함될때,post객체 안에 다시 place객체가 포함되어 있는 구조땜에 json직렬화 시 무한 루프가 반복될 때 쓴다.
    @OneToMany(mappedBy = "place",fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    private int postNumber=0; // 게시물 개수


    public void addPostNumber(int count) {
        postNumber += count;
    }
    public void incrementPostNumber() {
        postNumber++;
    }
    // place 자체에 대한 정보나 조회를 할 경우에는 placeRepository가 필요하겠지만 보통 place에 대한 게시물을 조회한다고 했을 때 postRepository에서 수행하는 것이 적합하다.
    // address랑 place랑 굳이 나눠야 하나 싶다. 합쳐서 다시 생각해보는 것이 좋아보임





}
