//package study.restaurant.user.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//import study.restaurant.user.domain.User;
//
//
//
//@Mapper(componentModel = "spring")
//public interface UserMapper {
//
//    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
//
//    @Mapping(target = "id",ignore = true)
//    User toEntity(User dto);
//
//    SignupDto toDto(User user);
//}
