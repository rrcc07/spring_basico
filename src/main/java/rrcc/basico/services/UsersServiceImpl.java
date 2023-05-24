package rrcc.basico.services;

import org.springframework.stereotype.Service;
import rrcc.basico.dtos.NewUserDTO;
import rrcc.basico.dtos.UserDTO;
import rrcc.basico.models.User;
import rrcc.basico.persistence.UserRepository;
import rrcc.basico.persistence.jpa.repositories.UserDAORepository;
import rrcc.basico.services.mappers.NewUserDTOMapper;
import rrcc.basico.services.mappers.UserDTOMapper;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService<UserDTO, NewUserDTO> {
    UserRepository<User> repository;
    //Mapper<User, UserDTO> userToUserDTOMapper;
    //Mapper<NewUserDTO, User> newUserDTOToUserMapper;
    //añadimos mapstruct
    UserDTOMapper userDTOMapper;
    NewUserDTOMapper newUserDTOMapper;

    public UsersServiceImpl(UserRepository<User> repository, UserDTOMapper userDTOMapper, NewUserDTOMapper newUserDTOMapper) {
        this.repository = repository;
        this.userDTOMapper = userDTOMapper;
        this.newUserDTOMapper = newUserDTOMapper;
    }

    @Override
    public Collection<UserDTO> getAll(){
        //return repository.getAll().stream().map(user -> userToUserDTOMapper.map(user)).collect(Collectors.toList());
        return repository.getAll().stream().map(user -> userDTOMapper.toUser(user)).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> get(long id){
        //return repository.get(id).map(user -> userToUserDTOMapper.map(user));
        return repository.get(id).map(user -> userDTOMapper.toUser(user));
    }

    @Override
    public UserDTO create(NewUserDTO newUserDTO) {
        //User user = newUserDTOToUserMapper.map(newUserDTO);
        //return userToUserDTOMapper.map(repository.create(user));
        User user = newUserDTOMapper.toUser(newUserDTO);
        return userDTOMapper.toUser(repository.create(user));
    }

    @Override
    public boolean delete(long id) {
        return repository.delete(id);
    }

    @Override
    public boolean exist(long id) {
        return repository.exist(id);
    }
}
