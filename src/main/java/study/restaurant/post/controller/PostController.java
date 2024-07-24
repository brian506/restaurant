package study.restaurant.post.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
<<<<<<< HEAD
=======
import org.springframework.http.HttpStatus;
>>>>>>> 3eff6d8 (Initial commit)
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.restaurant.post.domain.Address;
import study.restaurant.post.domain.Place;
import study.restaurant.post.domain.Post;
import study.restaurant.post.dto.PostRequestDto;
import study.restaurant.post.service.PostService;
<<<<<<< HEAD
=======
import study.restaurant.util.SuccessResponse;
>>>>>>> 3eff6d8 (Initial commit)


import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService postService;

    // {POST} 한 화면에 정보 입력
    @PostMapping()
<<<<<<< HEAD
    public ResponseEntity<Long> create(@RequestBody @Valid PostRequestDto postRequestDto) {
        System.out.println("1");
        Long post = postService.createPost(postRequestDto);
        System.out.println("2");
        return  ResponseEntity.ok(post);
=======
    public ResponseEntity<?> create(@RequestBody @Valid PostRequestDto postRequestDto) {
        Long post = postService.createPost(postRequestDto);
        SuccessResponse response = new SuccessResponse(true,"게시물 생성 완료",post);
        return  new ResponseEntity<>(response, HttpStatus.OK);
>>>>>>> 3eff6d8 (Initial commit)

    }

    // {GET} 지역에 따른 맛집들 조회
    @GetMapping("/places")
<<<<<<< HEAD
    public ResponseEntity<List<Post>> getPostsByPlace(@RequestParam Place place) {
        List<Post> posts = postService.findPostsByPlace(place);
        return ResponseEntity.ok(posts);
=======
    public ResponseEntity<?> getPostsByPlace(@RequestParam Place place) {
        List<Post> posts = postService.findPostsByPlace(place);
        SuccessResponse response = new SuccessResponse(true,"가게 조회 성공",posts);
        return new ResponseEntity<>(response, HttpStatus.OK);
>>>>>>> 3eff6d8 (Initial commit)
    }
    // 조회할 때는 post객체에서 봐도 되는지? dto를 끌고 와서 dto로 봐야 하는지?

    //{GET} 가게이름에 따른 맛집들 조회
    @GetMapping("/placeNames")
<<<<<<< HEAD
    public ResponseEntity<Post> getPostByPlaceName(@RequestParam String placeName) {
        Optional<Post> post = postService.findPostsByPlaceName(placeName);
        return post.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
=======
    public ResponseEntity<?> getPostByPlaceName(@RequestParam String placeName) {
        Optional<Post> post = postService.findPostsByPlaceName(placeName);
        SuccessResponse response = new SuccessResponse(true,"가게 조회 성공",post);
        return new ResponseEntity<>(response, HttpStatus.OK);
>>>>>>> 3eff6d8 (Initial commit)
    }
    // ResponseEntity<Post>는 HTTP 응답의 본문에 Post 객체를 포함할 수 있는 응답 엔터티를 반환
    // 검색된 Post 객체가 있으면 HTTP 200 상태 코드와 함께 Post 객체를 반환하고, 없으면 HTTP 404 상태 코드를 반환

    //{GET} 주소에 따른 맛집 조회
    @GetMapping("/search")
<<<<<<< HEAD
    public List<Post> getPostsByAddress(@RequestBody Address address){
        return postService.findByAddress(address);
    }
=======
    public ResponseEntity<?> getPostsByAddress(@RequestParam(required = false) String city,
                                               @RequestParam(required = false) String district,
                                               @RequestParam(required = false) String road){
        List<Post> posts = postService.findByAddress(city,district,road);
        SuccessResponse response = new SuccessResponse(true,"가게 조회 성공",posts);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    /**
     *   city, district,road 중 하나만 검색조건을 이용해도 조회할 수 있으려면?
     *   각각 따로 @RequestParam으로 따로 받고 , required = false 로 필수요건이 아님을 설정한다.
     *   그리고 repository에서 쿼리문을 이와 같이 쓴다.
     */

>>>>>>> 3eff6d8 (Initial commit)
}

