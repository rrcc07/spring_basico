package rrcc.basico.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//@Data
public class User {

    private long id;
    private String name;
    private List<Post> posts;

    public User(){
        posts = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> post) {
        this.posts = post;
    }
}
