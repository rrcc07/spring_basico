package rrcc.basico.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

//@Data
public class NewPostDTO {
    @NotNull(message = "text cannot be null")
    @Size(max = 255)
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
