package top.aqlog;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.Repository;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import javax.sql.DataSource;


@SpringBootApplication
@EnableRetry
@Slf4j
public class BlogApiApplication {
    public static void main(String[] args) {

        SpringApplication.run(BlogApiApplication.class, args);

        log.info("=========BLOG APPLICATION IS RUNNING!========");
    }

}
