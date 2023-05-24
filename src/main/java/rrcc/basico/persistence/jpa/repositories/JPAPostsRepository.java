package rrcc.basico.persistence.jpa.repositories;

import org.springframework.stereotype.Repository;
import rrcc.basico.models.Post;
import rrcc.basico.persistence.PostsRepository;
import rrcc.basico.persistence.jpa.mappers.PostDAOMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class JPAPostsRepository implements PostsRepository<Post> {

    PostDAORepository postDAORepository;
    PostDAOMapper postDAOMapper;

    public JPAPostsRepository(PostDAORepository postDAORepository, PostDAOMapper postDAOMapper) {
        this.postDAORepository = postDAORepository;
        this.postDAOMapper = postDAOMapper;
    }

    @Override
    public Collection<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        postDAORepository.findAll().forEach(postDAO -> posts.add(postDAOMapper.toPost(postDAO)));
        return posts;
    }

    @Override
    public Collection<Post> getAll(long userId) {
        List<Post> posts = new ArrayList<>();
        postDAORepository.findAllByUserId(userId).forEach(postDAO -> posts.add(postDAOMapper.toPost(postDAO)));
        return posts;
    }

    @Override
    public Optional<Post> get(long userId, long postId) {
        return postDAORepository.findByUserIdAndId(userId, postId).map(postDAOMapper::toPost);
    }

    @Override
    public Post create(long userId, Post post) {
        post.setUserId(userId);
        return postDAOMapper.toPost(postDAORepository.save(postDAOMapper.toPost(post)));
    }
}
