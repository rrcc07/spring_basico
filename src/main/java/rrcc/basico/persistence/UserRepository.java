package rrcc.basico.persistence;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository<TypeUser>{

    Collection<TypeUser> getAll();
    Optional<TypeUser> get(long id);
    TypeUser create(TypeUser typeUser);
    boolean delete(long id);
    boolean exist(long id);
}
