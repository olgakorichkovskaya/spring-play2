package org.play.bfpp;

import org.play.b.A;
import org.play.b.B;
import org.play.c.MessagerInterface;
import org.play.mytransactional.Service;
import org.play.mytransactional.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @DeprecatedClass can substitute one class with another (old by newer)
 * using BeanFactoryPostProcessor
 */
@Configuration
@ComponentScan(basePackages = "org.play.bfpp")
@EnableAutoConfiguration
public class MAin {

    @Bean
    public OldClassInterface oldClassInterface() {
        return new OldClass();
    }

    @Autowired
    private OldClassInterface oldClass;

    @PostConstruct
    private void init() throws InterruptedException {
        oldClass.a();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(MAin.class)
                .initializers((ApplicationContextInitializer<GenericApplicationContext>) applicationContext -> {
                }).run(args);

    }
}
