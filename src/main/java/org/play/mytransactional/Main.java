package org.play.mytransactional;

import org.play.b.A;
import org.play.b.B;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@ComponentScan(basePackages = "org.play.mytransactional")
@ImportResource("classpath*:spring.xml")
@EnableAutoConfiguration

public class Main {
    @Autowired
    private Service someService;

    @Bean
    public Service s() {
        return new SomeService();
    }


    @PostConstruct
    private void init() throws InterruptedException {
        someService.a();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class)
                .initializers(new ApplicationContextInitializer<GenericApplicationContext>() {
                    @Override
                    public void initialize(GenericApplicationContext applicationContext) {
                        // applicationContext.setAllowBeanDefinitionOverriding(false);
                    }
                }).run(args);

    }
}
