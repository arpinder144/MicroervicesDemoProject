package co.pragra.learning.app1.service;

import co.pragra.learning.app1.entity.GitUser;
import co.pragra.learning.app1.repository.GitUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
public class GitUserService {
    @Autowired
    GitUserRepo gitUserRepo;

    public Optional<GitUser> findByLogin(String login) {
        if (gitUserRepo.findByLogin(login).isPresent()) {
            return Optional.of(gitUserRepo.findByLogin(login).get());
        } else {

            WebClient webClient = WebClient.builder().build();
            GitUser user = webClient.get().uri("https://api.github.com/users/" + login).retrieve().bodyToMono(GitUser.class).block();
            gitUserRepo.save(user);
            return Optional.of(user);
        }


    }
}