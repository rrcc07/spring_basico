package rrcc.basico.services.mappers;

import org.springframework.stereotype.Component;
import rrcc.basico.dtos.NewUserDTO;
import rrcc.basico.models.User;

@Component
public class NewUserDTOToUserMapper implements Mapper<NewUserDTO, User>{
    @Override
    public User map(NewUserDTO newUserDTO) {
        User user = new User();
        user.setName(newUserDTO.getName());
        return user;
    }
}
