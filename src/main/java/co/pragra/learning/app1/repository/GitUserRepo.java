package co.pragra.learning.app1.repository;

import co.pragra.learning.app1.entity.GitUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GitUserRepo extends JpaRepository<GitUser,Integer> {
    public Optional<GitUser> findByLogin(String login);
}
