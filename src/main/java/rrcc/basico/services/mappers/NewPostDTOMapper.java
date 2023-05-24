package rrcc.basico.services.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import rrcc.basico.dtos.NewPostDTO;
import rrcc.basico.models.Post;

@Mapper(componentModel = "spring")
public interface NewPostDTOMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Post toPost(NewPostDTO newPostDTO);
}
