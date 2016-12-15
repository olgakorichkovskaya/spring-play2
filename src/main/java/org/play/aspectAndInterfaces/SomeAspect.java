package org.play.aspectAndInterfaces;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Component
@Aspect
@EnableAspectJAutoProxy

public class SomeAspect {
    @After("execution(* org.play.aspectAndInterfaces..*.*(..))")
    public void print(){

//        out.println("It is aspect !");
    }
}
