package peaksoft.springsecurityexamwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.springsecurityexamwork.entity.Test;
import peaksoft.springsecurityexamwork.repository.TestRepository;
import peaksoft.springsecurityexamwork.service.TestService;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    @Override
    public Test findUserByFirstName(String username) {
        return testRepository.findByTitle(username);
    }

    @Override
    public Test saveUser(Test test) {
        return testRepository.save(test);
    }

    @Override
    public List<Test> findAllUsers() {
        return testRepository.findAll();
    }

    @Override
    public Optional<Test> findById(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        testRepository.deleteById(id);
    }
}
