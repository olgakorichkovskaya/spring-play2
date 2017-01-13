package org.play.bfpp;

import org.play.mytransactional.SomeService;
import org.springframework.stereotype.Component;
@DeprecatedClass(newImpl = NewerVerion.class)
@Component
public class OldClass implements OldClassInterface {

    @Override
    public void a() {
        System.out.println("Old");
    }
}
