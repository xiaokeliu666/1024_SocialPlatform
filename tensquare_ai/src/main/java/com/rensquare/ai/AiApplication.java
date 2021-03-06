package com.rensquare.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.swing.*;

@SpringBootApplication
@EnableScheduling
public class AiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AiApplication.class,args);
    }
}
