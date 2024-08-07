package study.restaurant.user.service.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import study.restaurant.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceValidationImpl implements UserServiceValidation{

    private final UserRepository userRepository;

    private static final String ALREADY_EXIST_EMAIL_ERROR = "이미 등록된 이메일입니다";
    private static final String ALREADY_EXIST_NAME_ERROR = "이미 등록된 회원입니다";

    //중복예외 발생
    @Override
    public void validateSignUp(String username,String email) throws Exception {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new Exception(ALREADY_EXIST_NAME_ERROR);
        }
        if (userRepository.findByEmail(email).isPresent()) {
            throw new Exception(ALREADY_EXIST_EMAIL_ERROR);
        }
    }
}
