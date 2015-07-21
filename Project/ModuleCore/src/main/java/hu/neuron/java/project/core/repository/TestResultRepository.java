package hu.neuron.java.project.core.repository;

import hu.neuron.java.project.core.entity.TestResult;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface TestResultRepository extends JpaRepository<TestResult, Long> {

}
