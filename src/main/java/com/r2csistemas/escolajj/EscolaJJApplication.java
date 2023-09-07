package com.r2csistemas.escolajj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;

@SpringBootApplication(exclude = SqlInitializationAutoConfiguration.class)
public class EscolaJJApplication
        implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EscolaJJApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Sistema inicializado. Aqui podemos usar services e disparar o que quisermos ao startar o sistema");
    }
}
