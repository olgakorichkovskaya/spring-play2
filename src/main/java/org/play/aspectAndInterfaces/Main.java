package org.play.aspectAndInterfaces;

import org.play.b.A;
import org.play.b.B;
import org.play.mytransactional.Service;
import org.play.mytransactional.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackages = "org.play.aspectAndInterfaces")
@EnableAutoConfiguration
public class Main {

    @Autowired
    private IUnderAspect iUnderAspect;


    @PostConstruct
    private void init() throws InterruptedException {
        iUnderAspect.run();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class)
                .initializers(new ApplicationContextInitializer<GenericApplicationContext>() {
                    @Override
                    public void initialize(GenericApplicationContext applicationContext) {
                       }
                }).run(args);

    }
}
