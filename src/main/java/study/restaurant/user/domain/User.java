package study.restaurant.user.domain;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.restaurant.post.domain.Post;
import study.restaurant.timeDomain.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
// 생성자 생성해주는 어노테이션
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "NAME") // 글자 수 10 제한
    @NotEmpty() // 필수 입력사항
    private String username;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Post> posts  = new ArrayList<>(); // post가 주인

    @Email
    private String email;

    @Size(min = 8, message = "비밀번호는 8자리 이상으로 입력해주세요")
    private String password;


    /**
     * Spring Security Code
     * @param passwordEncoder
     */
//    public void passwordEncode(PasswordEncoder passwordEncoder){
//        this.password = passwordEncoder.encode(this.password);
//    } // 사용자의 password를 암호화하는 것

   // public void updateRefreshToken(String updateRefreshToken){
        //this.refreshToken = updateRefreshToken;
     // 사용자입장에서 refreshToken을 업데이트 하는 것




}
