package org.play.aspectAndInterfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//final class is proxied - dynamic proxy is used instead of cglib
// proxy name @Proxy11
@Component
public final class UnderAspect implements IUnderAspect {

//    @Autowired
//    private IUnderAspect underAspect;

    @PostConstruct
    public void init(){
//        underAspect.run();
    }

    @Override
    public void run() {

    }
}
