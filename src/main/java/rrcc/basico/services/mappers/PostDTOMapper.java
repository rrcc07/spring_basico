package rrcc.basico.services.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import rrcc.basico.dtos.PostDTO;
import rrcc.basico.models.Post;

@Mapper(componentModel = "spring")
public interface PostDTOMapper {
    PostDTO toPost(Post post);

    @InheritInverseConfiguration
    Post toPost(PostDTO postDTO);
}
