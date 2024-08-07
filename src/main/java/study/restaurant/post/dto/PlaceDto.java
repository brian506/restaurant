package study.restaurant.post.dto;

import lombok.Getter;
import study.restaurant.post.domain.Place;

@Getter
public class PlaceDto {
    // placeDto를 활용하여 순환방지문제를 해결
    // 객체에 관한 엔티티는 dto를 다 활용해서 넘기는 것이 편한다.

    private Long id;
    private String placeName;

    // place객체를 placeDto로 변환하는 정적 메서드
    public static PlaceDto fromEntity(Place place) {
        PlaceDto placeDto = new PlaceDto();
        placeDto.id = place.getId();
        placeDto.placeName = place.getPlaceName();
        return placeDto;
    }
}
