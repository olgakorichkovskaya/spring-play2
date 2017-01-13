package org.play.c;

import org.play.c.profiling.Profiling;
import org.play.c.randomannotation.RandomInt;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static java.lang.System.out;

@Component
@Profiling
public class Messager implements MessagerInterface {

    private String msg;

    @RandomInt(min = 2, max = 7)
    private int repeat;

    Messager() {
        out.println(" Fase 1  repeat =" + repeat);

    }

    @PostConstruct
    public void init() {
        out.println(" Fase 2  repeat =" + repeat);

    }

    @PostProxy
    @Override
    public String send() {
        out.println("Faces 3 " );
        out.println(" repeat " + repeat);
        for (int i = 0; i < repeat; i++) {
            out.println(" Send " + msg);

        }
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
