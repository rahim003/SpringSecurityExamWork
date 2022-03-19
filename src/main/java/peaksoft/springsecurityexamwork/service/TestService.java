package peaksoft.springsecurityexamwork.service;



import peaksoft.springsecurityexamwork.entity.Test;

import java.util.List;
import java.util.Optional;

public interface TestService {
    Test findUserByFirstName(String username);

    public Test saveUser(Test test);

    List<Test> findAllUsers();

    Optional<Test> findById(Long id);

    void deleteById(Long id);
}
