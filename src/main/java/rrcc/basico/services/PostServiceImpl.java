package rrcc.basico.services;

import org.springframework.stereotype.Service;
import rrcc.basico.dtos.NewPostDTO;
import rrcc.basico.dtos.PostDTO;
import rrcc.basico.models.Post;
import rrcc.basico.persistence.PostsRepository;
import rrcc.basico.services.mappers.Mapper;
import rrcc.basico.services.mappers.NewPostDTOMapper;
import rrcc.basico.services.mappers.PostDTOMapper;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService<PostDTO, NewPostDTO>{

    PostsRepository<Post> postsRepository;
    Mapper<Post, PostDTO> postToPostDTOMapper;
    Mapper<NewPostDTO, Post> newPostDTOToPostMapper;

    //añadimos mapstruct
    PostDTOMapper postDTOMapper;
    NewPostDTOMapper newPostDTOMapper;

    public PostServiceImpl(PostsRepository<Post> postsRepository, Mapper<Post, PostDTO> postToPostDTOMapper, Mapper<NewPostDTO, Post> newPostDTOToPostMapper, PostDTOMapper postDTOMapper, NewPostDTOMapper newPostDTOMapper) {
        this.postsRepository = postsRepository;
        this.postToPostDTOMapper = postToPostDTOMapper;
        this.newPostDTOToPostMapper = newPostDTOToPostMapper;
        this.postDTOMapper = postDTOMapper;
        this.newPostDTOMapper = newPostDTOMapper;
    }

    @Override
    public Collection<PostDTO> getAll(long userId) {
        Collection<Post> posts = postsRepository.getAll(userId);
        //return posts.stream().map(post -> postToPostDTOMapper.map(post)).collect(Collectors.toList());
        return posts.stream().map(post -> postDTOMapper.toPost(post)).collect(Collectors.toList());
    }

    @Override
    public Optional<PostDTO> get(long userId, long postId) {
        //return postsRepository.get(userId, postId).map(post -> postToPostDTOMapper.map(post));
        return postsRepository.get(userId, postId).map(post -> postDTOMapper.toPost(post));
    }

    @Override
    public PostDTO create(long userId, NewPostDTO newUserDTO) {
        //Post post = newPostDTOToPostMapper.map(newUserDTO);
        //return postToPostDTOMapper.map(postsRepository.create(userId, post));
        Post post = newPostDTOMapper.toPost(newUserDTO);
        return postDTOMapper.toPost(postsRepository.create(userId, post));
    }

    @Override
    public Collection<PostDTO> getAll() {
        Collection<Post> posts = postsRepository.getAll();
        //return posts.stream().map(post -> postToPostDTOMapper.map(post)).collect(Collectors.toList());
        return posts.stream().map(post -> postDTOMapper.toPost(post)).collect(Collectors.toList());
    }

}
