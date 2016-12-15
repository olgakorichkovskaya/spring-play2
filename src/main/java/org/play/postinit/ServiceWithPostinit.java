package org.play.postinit;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ServiceWithPostinit {

    @PostConstruct
    private void init(){
        System.out.println("Post construct");
    }
    //work after full initialisation, when proxy is created
    @PostInitialize
    @Deprecated
    public void postInitialize(){
        System.out.println("Post init");
    }
}
