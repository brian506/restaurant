package study.restaurant.user.service.validation;

import org.springframework.stereotype.Component;



public interface UserServiceValidation {
    void validateSignUp(String email,String username) throws Exception;


}
