package co.pragra.learning.app1.service;

import co.pragra.learning.app1.entity.GitUser;
import co.pragra.learning.app1.repository.GitUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GitUserService {
    @Autowired
    GitUserRepo gitUserRepo;

    public Optional<GitUser> findByLogin(String login){
        Optional<GitUser> user = gitUserRepo.findByLogin(login);
        return user;
    }

    public void saveAllGitUserInDb(GitUser user){
        gitUserRepo.save(user);

    }


}
