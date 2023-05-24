package rrcc.basico.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private long id;
    private String name;
    private int postCounter;

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

    public int getPostCounter() {
        return postCounter;
    }

    public void setPostCounter(int postCounter) {
        this.postCounter = postCounter;
    }
}
