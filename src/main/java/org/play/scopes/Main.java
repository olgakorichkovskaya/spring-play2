package org.play.scopes;


import org.play.profilingandother.MessagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackages = "org.play.scopes")
@EnableAutoConfiguration
public class Main {

    @Autowired
    private Singleton singleton;

    @Bean
    protected Singleton get(){
        return new Singleton();
    }


    @PostConstruct
    private void init() throws InterruptedException {

    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class)
                .initializers((ApplicationContextInitializer<GenericApplicationContext>) applicationContext -> {
                }).run(args);

    }
}
