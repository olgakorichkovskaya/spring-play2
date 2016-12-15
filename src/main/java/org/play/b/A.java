package org.play.b;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class A {
    @PostConstruct
    public void inti(){
        System.out.println("Init A");
    }
}
