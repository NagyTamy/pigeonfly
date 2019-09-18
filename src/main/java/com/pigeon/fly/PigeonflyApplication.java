package com.pigeon.fly;

import com.pigeon.fly.model.Pigeon;
import com.pigeon.fly.repository.PigeonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PigeonflyApplication {

    public static void main(String[] args) {
        SpringApplication.run(PigeonflyApplication.class, args);
    }

  @Bean
  public CommandLineRunner demoData(PigeonRepository repo) {
    return args -> {

      repo.save(new Pigeon("Marty Mcfly", 500, 40, "src/main/webapp/src/assets/images/pigeon1.jpg"));
      repo.save(new Pigeon("Stephen Squaking", 500, 40, "pigeon4.jpg"));
      repo.save(new Pigeon("The Godfeather", 500, 40, "/assets/images/pigeon3.jpg"));
    };
  }

}
