package org.play.mytransactional;

import org.play.postinit.PostInitialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@MyTransactional
@Component
public class SomeService implements Service {

    @Autowired
    private Service proxy;

    //    @Override
    public void a() {
        withdrow();
        deposit();
    }

//    @Transactional(propagation = Propagation.MANDATORY)
    private void withdrow() {
    }

//    @Transactional(propagation = Propagation.REQUIRED)
    private void deposit() {
        //in inner call tansastion does not work - use self injection
        proxy.inner();
    }

    //    @Override
    public void inner() {

    }


}
