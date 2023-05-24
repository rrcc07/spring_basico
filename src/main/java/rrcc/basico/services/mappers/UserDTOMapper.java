package rrcc.basico.services.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import rrcc.basico.dtos.UserDTO;
import rrcc.basico.models.User;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {
     @Mappings({
        //@Mapping(target = "id", source = "id") //automaticamente mapeado
        @Mapping(target = "postCounter", expression = "java(user.getPosts().size())" )
     })
    UserDTO toUser(User user);

    @InheritInverseConfiguration
    User toUser(UserDTO userDTO);
}
