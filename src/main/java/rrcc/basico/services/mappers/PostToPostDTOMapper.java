package rrcc.basico.services.mappers;

import org.springframework.stereotype.Component;
import rrcc.basico.dtos.PostDTO;
import rrcc.basico.models.Post;

@Component
public class PostToPostDTOMapper implements Mapper<Post, PostDTO>{

    @Override
    public PostDTO map(Post post) {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(post.getId());
        postDTO.setText(post.getText());
        return postDTO;
    }
}
