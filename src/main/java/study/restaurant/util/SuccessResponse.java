package study.restaurant.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SuccessResponse<T> {
    /**
     * client가 응답을 요청하고 이에 대한 성공 여부, 내용 등을 알아보기 쉽게 따로 클래스를 설정한다.
     */
    private boolean success;
    private T message;
    private T data;
}
