package study.restaurant.post.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    // 맛집에 따른 여러 정보들과 같이 embedded
    // 단점에 관해 문자열로 입력
    // 150자 제한
    // comment에 관한 테이블은 게시물에 다른 사람이 comment를 단다고 했을때 다대일 연관관계로 맺는다
    // 여기서는 한 사람이 본인 게시글에 하나의 comment만 다는 것이므로 필드 값으로 dto를 보내준다.
    // dto를 보낼때 entity를 보내면 안된다. 필드값만을 보내주도록 한다.

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;


}
