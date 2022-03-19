package peaksoft.springsecurityexamwork.service;

import peaksoft.springsecurityexamwork.entity.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question saveUser(Question question);

    List<Question> findAllUsers();

    Optional<Question> findById(Long id);

    void deleteById(Long id);
}
