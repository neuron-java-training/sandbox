package hu.neuron.java.core.dao;

import hu.neuron.java.core.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface UserDao extends JpaRepository<User, Long> {

	User findUserByName(@Param("userName") String name) throws Exception;

	Page<User> findByUserNameStartsWith(String filter,Pageable pageable);

}
