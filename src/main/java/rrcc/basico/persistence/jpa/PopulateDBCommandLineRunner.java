package rrcc.basico.persistence.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rrcc.basico.persistence.jpa.daos.PostDAO;
import rrcc.basico.persistence.jpa.daos.UserDAO;
import rrcc.basico.persistence.jpa.repositories.PostDAORepository;
import rrcc.basico.persistence.jpa.repositories.UserDAORepository;

@Component
public class PopulateDBCommandLineRunner implements CommandLineRunner {

    UserDAORepository userDAORepository;
    PostDAORepository postDAORepository;

    public PopulateDBCommandLineRunner(UserDAORepository userDAORepository, PostDAORepository postDAORepository) {
        this.userDAORepository = userDAORepository;
        this.postDAORepository = postDAORepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /**UserDAO userDAO = new UserDAO();
        userDAO.setName("Amir");
        userDAO = userDAORepository.save(userDAO);

        PostDAO postDAO = new PostDAO();
        postDAO.setUserId(userDAO.getId());
        postDAO.setUserDAO(userDAO);
        postDAO.setText("hello del command");
        postDAORepository.save(postDAO);*/
    }
}
