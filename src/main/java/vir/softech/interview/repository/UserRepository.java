package vir.softech.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vir.softech.interview.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
