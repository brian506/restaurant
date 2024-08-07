package study.restaurant.post.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import study.restaurant.timeDomain.BaseTimeEntity;
import study.restaurant.user.domain.User;


@Entity
@Table(name = "post")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // post 주인
    @JsonBackReference
    private User user;
    //xToOne은 모두 무조건 (fetch = FetchType.LAZY)요걸 입력해야 한다!!
    // 값이 다 딸려나오기 때문에 어려움을 겪을 수 있다

    @Setter
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id")
    private Place place;


    private String restaurant;

    @Embedded
    private Address address;

    private String comment;
    // 사용자 한명이 가게에 대한 리뷰를 달 때 코멘트도 하나만 달면 되는 것이므로 엔티티가 필요하지 않고 필드값만 설정해주면됨
    // 필드값으로 해도 comment정보는 다 남아있음

    @Setter
    @Enumerated(EnumType.STRING)
    private Rate rate;

    private int score;

    public void setScore(int score) {

        if (rate != null && !rate.ScoreRange(score)) {
            throw new IllegalArgumentException("평점을 다시 확인해주세요.범위 안에 있어야 합니다.");
        }
        this.score = score;
    }




}
