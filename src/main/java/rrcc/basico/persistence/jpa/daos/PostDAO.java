package rrcc.basico.persistence.jpa.daos;

import jakarta.persistence.*;

@Entity
@Table(name = "POSTS")
public class PostDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String text;

    @Column(name = "user_id")
    private long userId;

    /**crear relacion de tablas, para obtener al user (varios posts pertencen solo a un usuario)*/
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserDAO userDAO;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
