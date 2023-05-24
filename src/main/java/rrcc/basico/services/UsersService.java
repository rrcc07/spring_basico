package rrcc.basico.services;

import java.util.Collection;
import java.util.Optional;

public interface UsersService<Type,TypeNew>{
    Collection<Type> getAll();
    Optional<Type> get(long id);
    Type create(TypeNew typeNew);
    boolean delete(long id);
    boolean exist(long id);
}
