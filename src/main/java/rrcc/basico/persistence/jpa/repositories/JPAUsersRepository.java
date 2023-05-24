package rrcc.basico.persistence.jpa.repositories;

import org.springframework.stereotype.Repository;
import rrcc.basico.models.User;
import rrcc.basico.persistence.UserRepository;
import rrcc.basico.persistence.jpa.mappers.UserDAOMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public class JPAUsersRepository implements UserRepository<User> {

    UserDAORepository userDAORepository;
    UserDAOMapper userDAOMapper;

    public JPAUsersRepository(UserDAORepository userDAORepository, UserDAOMapper userDAOMapper) {
        this.userDAORepository = userDAORepository;
        this.userDAOMapper = userDAOMapper;
    }

    @Override
    public Collection<User> getAll() {
        List<User> users = new ArrayList<>();
        userDAORepository.findAll().forEach(userDAO -> users.add(userDAOMapper.toUser(userDAO)));
        return users;
    }

    @Override
    public Optional<User> get(long id) {
        return userDAORepository.findById(id).map(userDAOMapper::toUser);
    }

    @Override
    public User create(User user) {
        return userDAOMapper.toUser(userDAORepository.save(userDAOMapper.toUser(user)));
    }

    @Override
    public boolean delete(long id) {
        userDAORepository.deleteById(id);
        return true;
    }

    @Override
    public boolean exist(long id) {
        return userDAORepository.existsById(id);
    }
}
