package peaksoft.springsecurityexamwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springsecurityexamwork.entity.Question;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Override
    List<Question> findAll();

    @Override
    <S extends Question> S save(S entity);

    @Override
    Optional<Question> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
