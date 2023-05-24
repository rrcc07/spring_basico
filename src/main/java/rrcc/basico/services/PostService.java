package rrcc.basico.services;

import java.util.Collection;
import java.util.Optional;

public interface PostService<Type, NewType> {
    Collection<Type> getAll(long userId);
    Optional<Type> get(long userId, long id);
    Type create(long userId, NewType newPostDTO);
    Collection<Type> getAll();
}
