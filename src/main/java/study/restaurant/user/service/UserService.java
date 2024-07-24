package study.restaurant.user.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.restaurant.user.domain.User;
import study.restaurant.user.dto.SignupDto;
import study.restaurant.user.repository.UserRepository;
import study.restaurant.user.service.validation.UserServiceValidation;
import study.restaurant.util.OptionalUtil;

import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserServiceValidation validation;


    //회원가입
    // dto에 있는 정보들을 entity로 변환 후에 userRepository에 저장
    public Long signUp(SignupDto signupDto) throws Exception{
       validation.validateSignUp(signupDto.getUsername(), signupDto.getEmail());

        User user = signupDto.toEntity();

        userRepository.save(user);

        return userRepository.save(user).getId();

    }

    // 회원이름으로 조회
    public Optional<User> findUserByUsername(String username){
        User user = OptionalUtil.getOrElseThrow(userRepository.findByUsername(username),"존재하지 않는 이름입니다.");
        return Optional.of(user);
        }
        // 매서드 앞에 Optional로 반환해준다고 했으므로 마지막에 return할때도 Optional로 감싸준다.

    // 이메일로 조회
    public Optional<User> findByEmail(String email){
      User user = OptionalUtil.getOrElseThrow(userRepository.findByEmail(email),"존재하지 않는 email 입니다.");
      return Optional.of(user);
    }

}

/**
 * username을 조회하고 값이 없을 때 예외를 던져줘서 에러 내용을 볼 수 있게 한다.
 * GlobalExceptionHandler를 만들어서 모든 예외를 처리하는 클래스를 만든다.
 */