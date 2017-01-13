package org.play.postconstruct;

import javax.annotation.PostConstruct;

public abstract class AbstractClassWithPostConstruct implements InterfaceWithPostConstruct{


    @PostConstruct
    private void init() {
        System.out.println("Abstract bean  PC");
    }
}
