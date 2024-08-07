package study.restaurant.post.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.restaurant.exception.ResourceNotFoundException;
import study.restaurant.post.domain.Place;
import study.restaurant.post.domain.Post;
import study.restaurant.post.dto.PlaceDto;
import study.restaurant.post.dto.PostRequestDto;
import study.restaurant.post.dto.PostResponseDto;
import study.restaurant.post.repository.PlaceRepository;
import study.restaurant.post.repository.PostRepository;
import study.restaurant.user.domain.User;
import study.restaurant.user.repository.UserRepository;
import study.restaurant.util.ListUtil;
import study.restaurant.util.OptionalUtil;


import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;



    @Transactional
    public Long createPost(PostRequestDto postRequestDto) {
        User user = userRepository.findById(postRequestDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        // user는 따로 입력 받아야 하므로 userRepository에서 불러온다
        // signupdto로 user엔티티 생성,조회
        Place place = placeRepository.findByPlaceName(postRequestDto.getPlaceName())
                .orElseGet(()->createNewPlace(postRequestDto));

        Post post = postRequestDto.toEntity();

        // post 엔티티 생성

        post.setUser(user);
        post.setPlace(place);

        place.incrementPostNumber();// 게시물 개수 1증가
        //post 엔티티에 user 설정
        post.setRate(postRequestDto.getRate());
        post.setScore(postRequestDto.getScore());

        return postRepository.save(post).getId();
    }

    private Place createNewPlace(PostRequestDto postRequestDto) {
        Place newPlace = new Place();
        newPlace.setPlaceName(postRequestDto.getPlaceName());
        return placeRepository.save(newPlace);
    } // 게시물을 생성할 때 처음에 place에 대한 값이 null로 발생해서 예외가 발생한다.
    // 그래서 처음에 게시물을 작성할 때 비어 있는 place 객체를 생성해서 거기 안에 값을 입력하도록 한다.



    public List<PostResponseDto> findPostsByPlace(String placeName) {
        Place place = placeRepository.findByPlaceName(placeName)
                .orElseThrow(() -> new ResourceNotFoundException("Place not found"));
        // placeName 사용하여 Place 객체 조회
        List<Post> posts = ListUtil.getOrElseThrowList(postRepository.findPostByPlace(place),"아직 작성된 게시물이 없습니다.");
        return posts.stream()
                .map(PostResponseDto::fromEntity) // post 객체를 입력 받아 -> dto 객체를 반환하는 정적 메서드
                .collect(Collectors.toList());
    }
    // 스트림은 주로 컬렉션의 요소를 순차적으로 처리하고 변환하거나 필터링할 때 유용하다.

    /**
     * 컨트롤러단이나 서비스 단에서 엔티티를 조회하는 것보단 dto로 조회를 받아야 유지보수에 좋다.
     */


    public PostResponseDto findByRestaurant(String restaurant){
        Post post = OptionalUtil.getOrElseThrow(postRepository.findByRestaurant(restaurant),"존재하지 않는 가게 이름입니다.");
        PostResponseDto postResponseDto = PostResponseDto.fromEntity(post); // DTO 변환을 한다.
        return postResponseDto;
    }

    public List<PostResponseDto> findByAddress(String city, String district,String road) {
        List<Post> posts= ListUtil.getOrElseThrowList(postRepository.findByAddress(city, district, road),"존재하지 않는 주소입니다.");
        return posts.stream()
                .map(PostResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
}
