package rrcc.basico.persistence.jpa.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import rrcc.basico.models.Post;
import rrcc.basico.persistence.jpa.daos.PostDAO;

@Mapper(componentModel = "spring")
public interface PostDAOMapper {
    Post toPost(PostDAO postDAO);

    @InheritInverseConfiguration
    PostDAO toPost(Post post);
}
