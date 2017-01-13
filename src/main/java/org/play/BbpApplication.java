package org.play;

import org.play.aspectAndInterfaces.IUnderAspect;
import org.play.b.A;
import org.play.b.B;
import org.play.bfpp.OldClass;
import org.play.bfpp.OldClassInterface;
import org.play.c.Messager;
import org.play.c.MessagerInterface;
import org.play.mytransactional.Service;
import org.play.mytransactional.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan(basePackages = "")
@ImportResource("classpath*:spring.xml")
@EnableAutoConfiguration

public class BbpApplication {

    @Autowired
    private Service someService;

    @Autowired
    private IUnderAspect iUnderAspect;

    @Bean
    public A a() {
        return new A();
    }

    @Bean
    public A A() {
        return new A();
    }

    @Bean
    public Service s() {
        return new SomeService();
    }

    @Bean
    public B b() {
        return new B();
    }

    @PostConstruct
    private void init() throws InterruptedException {

        iUnderAspect.run();
        someService.a();

    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(BbpApplication.class)
                .initializers(new ApplicationContextInitializer<GenericApplicationContext>() {
                    @Override
                    public void initialize(GenericApplicationContext applicationContext) {
                        // applicationContext.setAllowBeanDefinitionOverriding(false);
                    }
                }).run(args);

    }
}
