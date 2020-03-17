package com.hendisantika.sekolah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SekolahApplication {

    public static void main(String[] args) {
        SpringApplication.run(SekolahApplication.class, args);
    }

}
