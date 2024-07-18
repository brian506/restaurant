package study.restaurant.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super();
        // 예외 객체를 설정하지만 별도의 메시지나 원인(cause)을 지정x
    }

    public ResourceNotFoundException(String message){
        super(message);
        // 예외를 생성할 때 사용자 정의 메시지 전달
    }

    public ResourceNotFoundException(String message,Throwable cause){
        super(message,cause);
        // 예외를 생성할 때 사용자 정의 메시지와 원잉ㄴ을 함께 전달
    }

    public ResourceNotFoundException(Throwable cause){
        super(cause);
        // 예외의 원인만 전달
    }
}
/**
 * @ResponseStatus : 예외가 발생했을 때 HTTP 응답 상태 코드를 설정
 * HttpStatus.NOT_FOUND : NOT_FOUND 는 HTTP 404 상태 코드 의미
 */