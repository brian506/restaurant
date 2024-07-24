package study.restaurant.post.domain;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
=======
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
>>>>>>> 3eff6d8 (Initial commit)
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

<<<<<<< HEAD
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // post 주인
=======
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // post 주인
    @JsonBackReference
>>>>>>> 3eff6d8 (Initial commit)
    private User user;
    //xToOne은 모두 무조건 (fetch = FetchType.LAZY)요걸 입력해야 한다!!
    // 값이 다 딸려나오기 때문에 어려움을 겪을 수 있다

    @Enumerated(EnumType.STRING) // enumtype도 같이 입력
    private Place place;

    private String placeName;

    @Embedded
    private Address address;

    private String comment;
    // 사용자 한명이 가게에 대한 리뷰를 달 때 코멘트도 하나만 달면 되는 것이므로 엔티티가 필요하지 않고 필드값만 설정해주면됨
    // 필드값으로 해도 comment정보는 다 남아있음
<<<<<<< HEAD
=======
    @Setter
>>>>>>> 3eff6d8 (Initial commit)
    @Enumerated(EnumType.STRING)
    private Rate rate;

    private int score;

    public void setScore(int score) {

        if (rate != null && !rate.ScoreRange(score)) {
            throw new IllegalArgumentException("평점을 다시 확인해주세요.범위 안에 있어야 합니다.");
        }
        this.score = score;
    }

<<<<<<< HEAD
    public void setUser(User user) {
        this.user = user;
    }

    public void setRate(Rate rate) {this.rate = rate;}
=======

>>>>>>> 3eff6d8 (Initial commit)
}
