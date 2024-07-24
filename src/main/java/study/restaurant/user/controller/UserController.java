package study.restaurant.user.controller;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.restaurant.user.dto.SignupDto;
import study.restaurant.user.service.UserService;
=======
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.restaurant.user.domain.User;
import study.restaurant.user.dto.SignupDto;
import study.restaurant.user.service.UserService;
import study.restaurant.util.SuccessResponse;

import java.util.Optional;
>>>>>>> 3eff6d8 (Initial commit)

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원 가입 api
    @PostMapping("/sign-up")
<<<<<<< HEAD
    public String signUp(@RequestBody SignupDto signupDto) throws Exception{
        userService.signUp(signupDto);
        return "success";
=======
    public ResponseEntity<?> signUp(@RequestBody @Valid SignupDto signupDto) throws Exception{
        Long user = userService.signUp(signupDto);
        SuccessResponse response = new SuccessResponse<>(true,"회원 등록 성공",user);
        return new ResponseEntity<>(response, HttpStatus.OK);
>>>>>>> 3eff6d8 (Initial commit)
    }


}
