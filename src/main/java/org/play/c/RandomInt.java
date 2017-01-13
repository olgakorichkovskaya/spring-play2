package org.play.c;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//create own annotation
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomInt {
//int min =0;
//int  max = 3;

    int min();

    int max();
}
