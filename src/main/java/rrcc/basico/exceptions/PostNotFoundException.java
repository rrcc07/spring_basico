package rrcc.basico.exceptions;

public class PostNotFoundException extends NotFoundException{
    public PostNotFoundException(long id) {
        super("Post id: " + id);
    }
}
