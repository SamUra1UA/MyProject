    package com.example.demo;

    import org.springframework.boot.CommandLineRunner;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.context.annotation.Bean;
    import java.util.Scanner;

    @SpringBootApplication
    public class Application {

        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }

        @Bean
        public CommandLineRunner commandLineRunner(ScheduleApp scheduleApp) {
            return args -> scheduleApp.start();
        }

        @Bean
        public Scanner scanner() {
            return new Scanner(System.in);
        }
    }
