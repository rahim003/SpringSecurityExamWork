package peaksoft.springsecurityexamwork.service;

import org.springframework.stereotype.Service;
import peaksoft.springsecurityexamwork.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService  {
    User findUserByFirstName(String username);

    public User saveUser(User user);

    List<User> findAllUsers();

   Optional <User> findById(Long id);

    void deleteById(Long id);

}
