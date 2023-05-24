package rrcc.basico.exceptions;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(long id){
        super("User id: " + id);
    }
}
