package rrcc.basico.persistence.jpa.mappers;

import org.mapstruct.*;
import rrcc.basico.models.User;
import rrcc.basico.persistence.jpa.daos.UserDAO;

@Mapper(componentModel = "spring")
public interface UserDAOMapper {
    User toUser(UserDAO userDAO);

    @InheritInverseConfiguration
    UserDAO toUser(User user);
}
