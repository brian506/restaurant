package study.restaurant.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.restaurant.user.domain.User;
import study.restaurant.user.dto.SignupDto;
import study.restaurant.user.repository.UserRepository;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    private static final String ALREADY_EXIST_EMAIL_ERROR = "이미 등록된 이메일입니다";
    private static final String ALREADY_EXIST_NAME_ERROR = "이미 등록된 회원입니다";

    //회원가입
    // dto에 있는 정보들을 entity로 변환 후에 userRepository에 저장
    public void signUp(SignupDto signupDto) throws Exception{
        validateSignUpDto(signupDto);

        User user = signupDto.toEntity();

        userRepository.save(user);
    }

    //중복예외 발생
    public void validateSignUpDto(SignupDto signupDto) throws Exception {
        if (userRepository.findByEmail(signupDto.getEmail()).isPresent()) {
            throw new Exception(ALREADY_EXIST_EMAIL_ERROR);
        }
        if (userRepository.findByUsername(signupDto.getUsername()).isPresent()) {
            throw new Exception(ALREADY_EXIST_NAME_ERROR);
        }

    }

}
