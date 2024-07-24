package study.restaurant.post.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.restaurant.exception.ResourceNotFoundException;
import study.restaurant.post.domain.Address;
import study.restaurant.post.domain.Place;
import study.restaurant.post.domain.Post;
import study.restaurant.post.dto.PostRequestDto;
import study.restaurant.post.repository.PostRepository;
import study.restaurant.user.domain.User;
import study.restaurant.user.repository.UserRepository;


import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


    @Transactional(readOnly = false)
    public Long createPost(PostRequestDto postRequestDto) {
        User user = userRepository.findById(postRequestDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        // user는 따로 입력 받아야 하므로 userRepository에서 불러온다
        // signupdto로 user엔티티 생성,조회

        Post post  = postRequestDto.toEntity();
        // post 엔티티 생성
        post.setUser(user);
        //post 엔티티에 user 설정

        post.setRate(postRequestDto.getRate());
        post.setScore(postRequestDto.getScore());

        return postRepository.save(post).getId();
    }


    public List<Post> findPostsByPlace(Place place) {
        return postRepository.findByPlace(place);
    }

    public Optional<Post> findPostsByPlaceName(String placeName){
        return postRepository.findByPlaceName(placeName);
    }
<<<<<<< HEAD
    public List<Post> findByAddress(Address address) {
        return postRepository.findByAddress(address.getCity(),address.getDistrict(), address.getRoad());
=======
    public List<Post> findByAddress(String city, String district,String road) {
        return postRepository.findByAddress(city, district, road);
>>>>>>> 3eff6d8 (Initial commit)
    }
}
