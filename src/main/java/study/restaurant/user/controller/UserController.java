package study.restaurant.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.restaurant.user.dto.SignupDto;
import study.restaurant.user.service.UserService;
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


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // 회원 가입 api
    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody @Valid SignupDto signupDto) throws Exception{
        Long user = userService.signUp(signupDto);
        SuccessResponse response = new SuccessResponse<>(true,"회원 등록 성공",user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 회원 이름으로 조회
    @GetMapping("/usernames")
    public ResponseEntity<?> getUserByUsername(@RequestParam String username){
        Optional<User> user = userService.findUserByUsername(username);
        SuccessResponse response = new SuccessResponse(true,"회원 조회 성공",user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // 회원 이메일로 조회
    @GetMapping("/emails")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email){
        Optional<User> user = userService.findByEmail(email);
        SuccessResponse response = new SuccessResponse(true,"회원 조회 성공",email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



}
