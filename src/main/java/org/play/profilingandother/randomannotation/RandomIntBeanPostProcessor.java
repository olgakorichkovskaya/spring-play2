package org.play.profilingandother.randomannotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;
// tuning beans during bean creation
@Component
public class RandomIntBeanPostProcessor implements BeanPostProcessor {

    Random r = new Random();

    //before init method
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {


        for (Field field : o.getClass().getDeclaredFields()) {
            RandomInt annotation = field.getAnnotation(RandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();


                int i = min + r.nextInt(max - min);
                field.setAccessible(true);
                ReflectionUtils.setField(field, o, i);


            }
        }
        return o;
    }

    //after init method
    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
