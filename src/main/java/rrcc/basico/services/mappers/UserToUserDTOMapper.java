package rrcc.basico.services.mappers;

import org.springframework.stereotype.Component;
import rrcc.basico.dtos.UserDTO;
import rrcc.basico.models.User;

@Component
public class UserToUserDTOMapper implements Mapper<User, UserDTO>{
    @Override
    public UserDTO map(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPostCounter(user.getPosts().size());
        return userDTO;
    }
}
