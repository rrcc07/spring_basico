package rrcc.basico.persistence.jpa.daos;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "USER")
//@Data
public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    @OneToMany(mappedBy = "userDAO", cascade = {CascadeType.ALL}) //añadimos "cascade" para eliminar todos los post
    private List<PostDAO> posts;

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

    public List<PostDAO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDAO> posts) {
        this.posts = posts;
    }
}
