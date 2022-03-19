package peaksoft.springsecurityexamwork.service;

import org.springframework.stereotype.Service;
import peaksoft.springsecurityexamwork.entity.Role;
import peaksoft.springsecurityexamwork.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    User findUserByFirstName(String username);

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String rolename);

    User getUser(String username);

    List<User> findAllUsers();

    Optional<User> findById(Long id);

    void deleteById(Long id);

}
