package az.softsolution.bookingsystem.mapper;

import az.softsolution.bookingsystem.dto.UserDto;
import az.softsolution.bookingsystem.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
    List<UserDto> toUserDtos(List<User> users);
    User toUser(UserDto userDto);
}
