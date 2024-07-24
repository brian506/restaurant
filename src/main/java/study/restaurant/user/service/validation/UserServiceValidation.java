package study.restaurant.user.service.validation;

import study.restaurant.user.dto.SignupDto;

public interface UserServiceValidation {
    void validateSignUp(String email,String username) throws Exception;


}
