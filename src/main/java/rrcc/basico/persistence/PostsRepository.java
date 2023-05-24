package rrcc.basico.persistence;

import java.util.Collection;
import java.util.Optional;

public interface PostsRepository<TypePost> {
    Collection<TypePost> getAll();
    Collection<TypePost> getAll(long userId);
    Optional<TypePost> get(long userId, long postId);
    TypePost create(long userId, TypePost typePost);
}
