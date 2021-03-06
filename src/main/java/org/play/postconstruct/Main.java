package org.play.postconstruct;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

/**
 *
 * make working @Postconstruct in Interfaces
 * It will not work for beans created in java config
 * these bean don't have BeanDefinitionName
 *
 */
@Configuration
@ComponentScan(basePackages = "org.play.postconstruct")
@EnableAutoConfiguration
public class Main {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class)
                .initializers(new ApplicationContextInitializer<GenericApplicationContext>() {
                    @Override
                    public void initialize(GenericApplicationContext applicationContext) {
                    }
                }).run(args);

    }
}
