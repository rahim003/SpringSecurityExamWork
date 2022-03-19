package peaksoft.springsecurityexamwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.springsecurityexamwork.entity.Test;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    Test findByTitle(String title);

    @Override
    List<Test> findAll();

    @Override
    <S extends Test> S save(S entity);

    @Override
    Optional<Test> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
