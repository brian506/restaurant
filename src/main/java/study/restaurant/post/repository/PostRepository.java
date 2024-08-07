package study.restaurant.post.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import study.restaurant.post.domain.Place;
import study.restaurant.post.domain.Post;


import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

  List<Post> findPostByPlace(Place place);
  // list로 한 이유는 장소에 대한 여러 게시물들을 보기 위해서임

  @Query("select count(p) from Post p where p.place.id = :placeId")
  int countPostsByPlaceId(@Param("placeId") Long placeId); // place 고유의 id에 따라 게시물 개수를 셀 수 있다.

  Optional<Post> findByRestaurant(String restaurant);
  // Optional로 한 이유는 가게 이름은 값이 하나라고만 생각하고 장소 한 곳에 대한 게시물만 보기 위해서임

  @Query("SELECT p FROM Post p WHERE"
          + "(:city IS NULL OR p.address.city = :city) AND "
                  + "(:district IS NULL OR p.address.district = :district) AND "
                  + "(:road IS NULL OR p.address.road = :road)")
  List<Post> findByAddress(@Param("city") String city,@Param("district") String district,@Param("road") String road);
  // 주소 정보를 기반으로 가게 이름을 조회, JPA메서드 쿼리는 메서드 이름을 기반으로 자동으로 쿼리를 생성
  /**
   *   city, district,road 중 하나만 검색조건을 이용해도 조회할 수 있으려면?
   *   각각 따로 @RequestParam으로 따로 받고 , required = false 로 필수요건이 아님을 설정한다.
   *   그리고 repository에서 쿼리문을 이와 같이 쓴다.
   */

}
