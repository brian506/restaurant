package study.restaurant.post.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rate {

    // 별로에요(0-1),보통이에요(2-3),맛있어요(4-5)
    // 각 평점에 대한 점수 범위 추가
    // 점수가 범위에 속하는지 확인하는 메서드 추가
    NOTRECOMMEND("별로에요",0,1),
    NOTBAD("괜찮아요",2,3),
    RECOMMEND("맛있어요",4,5);

    // enum값들의 대한 파라미터값 선언
    private final String description;
    private final int minScore;
    private final int maxScore;

    //항목에 대한 점수가 해당 평점의 범위 내에 있는 지 확인하는 역할
    //score가 저 점수 사이에 있는지 검증
    public boolean ScoreRange(int score){
        return score>=minScore && score<=maxScore;
    }







}
