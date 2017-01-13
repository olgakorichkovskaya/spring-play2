package org.play.postconstruct;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BeanWithPostConstruct extends AbstractClassWithPostConstruct{

    @PostConstruct
    private int init() {
        System.out.println("Bean PC");
        return 0;
    }

    @Override
    public void interfaceMethod() {
        System.out.println("Interface method (work as PC)");

    }
}
