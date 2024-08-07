package study.restaurant.post.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import study.restaurant.post.domain.Place;
import study.restaurant.post.dto.PostRequestDto;
import study.restaurant.post.dto.PostResponseDto;
import study.restaurant.post.service.PostService;

import study.restaurant.util.SuccessResponse;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/posts")
public class PostController {

    private final PostService postService;

    // {POST} 한 화면에 정보 입력
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody @Valid PostRequestDto postRequestDto) {
        Long post = postService.createPost(postRequestDto);
        SuccessResponse response = new SuccessResponse(true,"게시물 생성 완료",post);
        return  new ResponseEntity<>(response, HttpStatus.OK);


    }

    // {GET} 지역에 따른 맛집들 조회
    @GetMapping("/places")
    public ResponseEntity<?> getPostsByPlace(@RequestParam String placeName) {
        List<PostResponseDto> posts = postService.findPostsByPlace(placeName);
        SuccessResponse response = new SuccessResponse(true,"가게 조회 성공",posts);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    //컨트롤러에서 @RequestParam은 파라미터를 간단한 데이터 타입(String,int) 등으로 받아야함)

    //{GET} 가게이름에 따른 맛집들 조회
    @GetMapping("/restaurant")
    public ResponseEntity<?> getPostByPlaceName(@RequestParam String restaurant) {
        PostResponseDto post = postService.findByRestaurant(restaurant);
        SuccessResponse response = new SuccessResponse(true,"가게 조회 성공",post);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
    // ResponseEntity<Post>는 HTTP 응답의 본문에 Post 객체를 포함할 수 있는 응답 엔터티를 반환
    // 검색된 Post 객체가 있으면 HTTP 200 상태 코드와 함께 Post 객체를 반환하고, 없으면 HTTP 404 상태 코드를 반환

    //{GET} 주소에 따른 맛집 조회
    @GetMapping()
    public ResponseEntity<?> getPostsByAddress(@RequestParam(required = false                                                                           ) String city,
                                               @RequestParam(required = false) String district,
                                               @RequestParam(required = false) String road){
        List<PostResponseDto> posts = postService.findByAddress(city,district,road);
        SuccessResponse response = new SuccessResponse(true,"가게 조회 성공",posts);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    /**
     *   city, district,road 중 하나만 검색조건을 이용해도 조회할 수 있으려면?
     *   각각 따로 @RequestParam으로 따로 받고 , required = false 로 필수요건이 아님을 설정한다.
     *   그리고 repository에서 쿼리문을 이와 같이 쓴다.
     */


}

