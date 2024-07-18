package study.restaurant.user.service;//
//package security.account.user.service;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import security.account.user.domain.User;
//import security.account.user.repository.UserRepository;
//
//@Service
//@RequiredArgsConstructor
//public class LoginService implements UserDetailsService {
//    // userDetailsService는 사용자의 정보를 담는 인터페이스
//
//    private final UserRepository userRepository;
//
//
//    /**
//     *
//     * @param email the username identifying the user whose data is required.
//     * @return
//     * @throws UsernameNotFoundException
//     */
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("해당 이메일이 존재하지 않습니다"));
//
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getEmail())
//                .password(user.getEmail())
//                .build();
//    }
//}
