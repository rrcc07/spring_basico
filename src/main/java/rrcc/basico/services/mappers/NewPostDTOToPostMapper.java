package rrcc.basico.services.mappers;

import org.springframework.stereotype.Component;
import rrcc.basico.dtos.NewPostDTO;
import rrcc.basico.models.Post;

@Component
public class NewPostDTOToPostMapper implements Mapper<NewPostDTO, Post>{
    @Override
    public Post map(NewPostDTO newPostDTO) {
        Post post = new Post();
        post.setText(newPostDTO.getText());
        return post;
    }
}
