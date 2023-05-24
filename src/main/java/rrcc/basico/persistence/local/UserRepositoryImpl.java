package rrcc.basico.persistence.local;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rrcc.basico.models.Post;
import rrcc.basico.models.User;
import rrcc.basico.persistence.PostsRepository;
import rrcc.basico.persistence.UserRepository;

import java.util.*;

//@Repository //quitamos al implementar jpa
public class UserRepositoryImpl implements UserRepository<User> {
    private static long ID_GENERATOR = 0;
    private static List<User> USERS;

    @Autowired
    PostsRepository<Post> postsRepository;

    @PostConstruct
    public void init() {
        USERS = new ArrayList<>();
        User user = new User();
        user.setId(++ID_GENERATOR);
        user.setName("Amir");
        /***Post post = new Post();
        post.setId(1);
        post.setText("hello world");
        user.setPosts(List.of(post));*/

        user.setPosts((List<Post>) postsRepository.getAll(user.getId()));
        USERS.add(user);
    }

    @Override
    public Collection<User> getAll(){
        return USERS;
    }
    @Override
    public Optional<User> get(long id){
        return USERS.stream().filter(user -> user.getId() == id).findFirst();
    }

    @Override
    public User create(User user) {
        System.out.println(user);
        user.setId(++ID_GENERATOR);
        USERS.add(user);
        return user;
    }

    @Override
    public boolean delete(long id) {
        return USERS.removeIf(user -> user.getId() == id);
    }

    @Override
    public boolean exist(long id) {
        return USERS.stream().anyMatch(user -> user.getId() == id);
    }

}
