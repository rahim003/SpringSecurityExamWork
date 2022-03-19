package peaksoft.springsecurityexamwork.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.springsecurityexamwork.entity.Question;
import peaksoft.springsecurityexamwork.repository.QuestionRepository;
import peaksoft.springsecurityexamwork.service.QuestionService;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public Question saveUser(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> findAllUsers() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}
