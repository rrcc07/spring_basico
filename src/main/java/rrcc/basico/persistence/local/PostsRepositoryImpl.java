package rrcc.basico.persistence.local;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import rrcc.basico.models.Post;
import rrcc.basico.models.User;
import rrcc.basico.persistence.PostsRepository;

import java.util.*;

//@Repository //quitamos al implementar jpa
public class PostsRepositoryImpl implements PostsRepository<Post> {

    private static long ID_GENERATOR = 0;
    private static Map<Long, Set<Post>> POSTS_BY_USERID;

    @PostConstruct
    public void init(){
        POSTS_BY_USERID = new HashMap<>();
        Post post = new Post();
        post.setId(++ID_GENERATOR);
        post.setText("Hello world2");;
        Set<Post> posts = new HashSet<>();
        posts.add(post);
        POSTS_BY_USERID.put(1L, posts);
    }

    @Override
    public Collection<Post> getAll() {
        Set<Post> posts = new HashSet<>();
        for( Map.Entry<Long, Set<Post>> entry : POSTS_BY_USERID.entrySet()){
            posts.addAll(entry.getValue());
        }
        return posts;
    }

    @Override
    public Collection<Post> getAll(long userId) {
        return POSTS_BY_USERID.get(userId);
    }

    @Override
    public Optional<Post> get(long userId, long postId) {
        return getAll(userId).stream().filter(post -> post.getId() == postId).findFirst();
    }

    @Override
    public Post create(long userId, Post post) {
        post.setId(++ID_GENERATOR);
        System.out.println(post.getText());
        if(!POSTS_BY_USERID.containsKey(userId)){
            POSTS_BY_USERID.put(userId, new HashSet<>());
        }
        POSTS_BY_USERID.get(userId).add(post);
        return post;
    }
}
