package co.pragra.learning.app1.web;

import co.pragra.learning.app1.entity.GitUser;
import co.pragra.learning.app1.service.GitUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/github")
public class GitUserAPI {
    @Autowired
    GitUserService gitUserService;
    @GetMapping("/get/{login}")
    public GitUser getAllDataFromGitHub(@PathVariable String login){
        if (gitUserService.findByLogin(login).isPresent()){
           return gitUserService.findByLogin(login).get();
        }
        else {

            WebClient webClient = WebClient.builder().build();
        GitUser user = webClient.get().uri("https://api.github.com/users/" + login).retrieve().bodyToMono(GitUser.class).block();
        gitUserService.saveAllGitUserInDb(user);
        return user;
        }}


}
