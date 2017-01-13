package org.play.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class Singleton {

    @Autowired
    private Prototype prototype;

    @PostConstruct
    private void init() {
        System.out.println("PC Singleton");
    }


    @PreDestroy
    private void preDestroy() {
        System.out.println("PD single");
    }
}
