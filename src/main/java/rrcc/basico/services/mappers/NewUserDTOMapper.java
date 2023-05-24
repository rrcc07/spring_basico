package rrcc.basico.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import rrcc.basico.dtos.NewUserDTO;
import rrcc.basico.models.User;

@Mapper(componentModel = "spring")
public interface NewUserDTOMapper {
    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "posts", ignore = true)
    })
    User toUser(NewUserDTO newUserDTO);
}
