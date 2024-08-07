package study.restaurant.userTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import study.restaurant.user.domain.User;
import study.restaurant.user.dto.UserRequestDto;
import study.restaurant.user.dto.UserResponseDto;
import study.restaurant.user.repository.UserRepository;
import study.restaurant.user.service.UserService;
import study.restaurant.user.service.validation.UserServiceValidation;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceValidation userServiceValidation;


    @Test @Transactional
    void 회원가입_테스트() throws Exception {
        //given
        UserRequestDto userRequestDto = UserRequestDto.builder()
                .username("최영")
                .email("brian56@naver.com")
                .password("wind6298")
                .build();

        //when
        Long userId = userService.signUp(userRequestDto); // 사용자 등록
        Optional<User> userOptional = userRepository.findByUsername("최영"); // 사용자 조회

        assertTrue(userOptional.isPresent()); // 해당 사용자가 존재하는지 검증
        User user = userOptional.get(); // 존재한 사용자를 조회

        //then
        assertEquals(user.getId(), userId);
        assertEquals("최영", user.getUsername());
        assertEquals("brian56@naver.com", user.getEmail());
    }
    // 트랜잭션 사용하면 테스트 전 상황으로 돌아가야 하는데 왜 계속 중복된 이메일이라고 뜰까?
    // 중복에 대한 로직을 테스트하는 코드는 넣지 않았는데 어째서 중복에 대한 오류가 뜨는 걸까?

    /**
     * 여기서 Hibernate가 user테이블과 post테이블을 조회하는 SQL쿼리를 실행한 것. 사용자의 정보와 이와 관련된 게시물 정보를 조회한 것이다.
     * 그러므로 사용자의 정보를 조회하려면 각각의 도메인에 fetch = FETCHTYP.LAZY가 있어야 함
     *
     * signUp메서드에 예외발생(validation)이 연관되어 있으므로 위 로직에서 회원가입 중복에 대해서도 검증된다.
     */

    @Test @Transactional
    void 사용자이름_조회()  {
        //given
        User user = User.builder()
                .username("강예령")
                .email("brian@naver.com")
                .password("12345678")
                .build();

        //when
        userRepository.save(user);
        Optional<UserResponseDto> foundUser = userService.findUserByUsername("강예");

        //then
        assertTrue(foundUser.isPresent());
        assertEquals(user, foundUser.get());
    }

    @Test @Transactional
    void 사용자이메일_조회()  {
        //given
        User user = User.builder()
                .username("메시")
                .email("messi@gmail.com")
                .password("fuckUcr7")
                .build();

        //when
        userRepository.save(user);
        Optional<UserResponseDto> findEmail = userService.findByEmail("mesi@gmail.com");
        //then
        assertTrue(findEmail.isPresent());
        assertEquals(user, findEmail.get());
    }
//    @Test
//    void 회원정보_중복예외() throws Exception {
//        //given
//
//
//        //when
//
//
//        //then
//
//}
}