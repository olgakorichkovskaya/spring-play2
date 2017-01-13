package org.play.scopes;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Random;

@Component
@Scope("prototype")
public class Prototype {


    @PostConstruct
    private void init(){

        System.out.println("PC proto "+ new Random().nextInt());
    }

    //Spring don't keep prototypes after creation
    //method will not be called
    @PreDestroy
    private void preDestroy(){
        System.out.println("PD Proto");
    }
}
