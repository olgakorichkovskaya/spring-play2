package org.play;

import org.play.aspectAndInterfaces.IUnderAspect;
import org.play.b.A;
import org.play.b.B;
import org.play.mytransactional.Service;
import org.play.mytransactional.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Oreder of spring working:
 * BFPP -> BBP ->Bean ->
 */
@Configuration
@ComponentScan(basePackages = "org.play.b")
@ImportResource("classpath*:spring.xml")
@EnableAutoConfiguration
public class BbpApplication {

    @Bean
    public A a() {
        return new A();
    }

    @Bean
    public A A() {
        return new A();
    }

    @Bean
    public B b() {
        return new B();
    }

    @Value("${JAVA_HOME}")
    private String javaHome;

    @PostConstruct
    private void init() throws InterruptedException {
        System.out.println(javaHome);
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
