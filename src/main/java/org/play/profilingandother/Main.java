package org.play.profilingandother;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.PostConstruct;
//3 phases constructor:
// Constructor()  @POstconstruct and @PostProxy- @PostProxy works when all proxy is ready
//profiling using flag in MBeanServer
@Configuration
@ComponentScan(basePackages = "org.play.profilingandother")
@EnableAutoConfiguration
public class Main {

    @Autowired
    private MessagerInterface messager;

    @PostConstruct
    private void init() throws InterruptedException {

        while (true) {
            Thread.sleep(500);
            messager.send();
        }
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class)
                .initializers((ApplicationContextInitializer<GenericApplicationContext>) applicationContext -> {
                }).run(args);

    }
}
