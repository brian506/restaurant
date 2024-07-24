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

  List<Post> findByPlace(Place place);

  Optional<Post> findByPlaceName(String placeName);

<<<<<<< HEAD
  @Query("SELECT s FROM Post s WHERE s.address.city = :city AND s.address.district = :district AND s.address.road = :road")
  List<Post> findByAddress(@Param("city") String city,@Param("district") String district,@Param("road") String road);
  // 주소 정보를 기반으로 가게 이름을 조회, JPA메서드 쿼리는 메서드 이름을 기반으로 자동으로 쿼리를 생성
=======
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
>>>>>>> 3eff6d8 (Initial commit)
}
