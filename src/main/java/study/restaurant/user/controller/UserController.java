package study.restaurant.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.restaurant.user.dto.SignupDto;
import study.restaurant.user.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원 가입 api
    @PostMapping("/sign-up")
    public String signUp(@RequestBody SignupDto signupDto) throws Exception{
        userService.signUp(signupDto);
        return "success";
    }


}
