package co.pragra.learning.app1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class GitUser {
    private String login;
    private String node_id;
    @Id
    private Integer id;
    private String avatar_url;
    private String url;
    private String html_url;
    private String followers_url;
    private String subscriptions_url;
}
