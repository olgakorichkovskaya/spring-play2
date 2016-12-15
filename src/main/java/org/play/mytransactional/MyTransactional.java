package org.play.mytransactional;



import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Dewy on 13-Dec-16.
 */
@Retention(RetentionPolicy.RUNTIME)
//@Transactional
public @interface MyTransactional {
 //   Propagation propagation() default Propagation.REQUIRES_NEW;
}
