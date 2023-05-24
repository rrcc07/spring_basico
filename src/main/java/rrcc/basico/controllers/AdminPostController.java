package rrcc.basico.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rrcc.basico.dtos.NewPostDTO;
import rrcc.basico.dtos.PostDTO;
import rrcc.basico.services.PostService;

import java.util.Collection;

@RestController
@RequestMapping("/posts")
public class AdminPostController {

    PostService<PostDTO, NewPostDTO> postService;

    public AdminPostController(PostService<PostDTO, NewPostDTO> postService) {
        this.postService = postService;
    }

    @GetMapping
    public Collection<PostDTO> getAll(){
        return postService.getAll();
    }

}
