package co.pragra.learning.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
//@EnableDiscoveryClient
public class App1Application {

    public static void main(String[] args) {
        SpringApplication.run(App1Application.class, args);
    }

}
