package rrcc.basico.dtos;

import jakarta.validation.constraints.Size;
import lombok.Data;

//@Data
public class NewUserDTO {

    @Size(max = 100, message = "name should have at least 3 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
