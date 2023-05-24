package rrcc.basico.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rrcc.basico.dtos.NewPostDTO;
import rrcc.basico.dtos.NewUserDTO;
import rrcc.basico.dtos.PostDTO;
import rrcc.basico.dtos.UserDTO;
import rrcc.basico.exceptions.PostNotFoundException;
import rrcc.basico.models.User;
import rrcc.basico.services.PostService;
import rrcc.basico.services.UsersService;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("users/{userId}/posts")
public class PostController {

    PostService<PostDTO, NewPostDTO> postService;
    UsersService<UserDTO, NewUserDTO> userService;

    public PostController(PostService<PostDTO, NewPostDTO> postService, UsersService<UserDTO, NewUserDTO> userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Collection<PostDTO>> getAll(@PathVariable long userId){
        if(!userService.exist(userId)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(postService.getAll(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> get(@PathVariable long userId, @PathVariable long id){
        if(!userService.exist(userId)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(postService.get(userId, id).orElseThrow(() -> new PostNotFoundException(id)));
    }
    @PostMapping
    public ResponseEntity<PostDTO> create(@PathVariable long userId, @Valid @RequestBody NewPostDTO newUserDTO){
        if(!userService.exist(userId)){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        PostDTO userDTO = postService.create(userId, newUserDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
