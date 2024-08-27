package kr.ac.kopo.board2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Board2024Application {

    public static void main(String[] args) {
        SpringApplication.run(Board2024Application.class, args);
    }

}
