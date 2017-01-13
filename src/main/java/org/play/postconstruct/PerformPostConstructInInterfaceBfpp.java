package org.play.postconstruct;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

@Component
public class PerformPostConstructInInterfaceBfpp implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            if (beanClassName != null) {
                Class<?> aClass = ClassUtils.resolveClassName(beanClassName, this.getClass().getClassLoader());
                Class<?>[] allInterfaces = ClassUtils.getAllInterfacesForClass(aClass);
                for (Class<?> allInterface : allInterfaces) {
                    Method[] methods = allInterface.getMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(PostConstruct.class)) {
                            beanDefinition.setInitMethodName(method.getName());
                            System.out.println("Add Post construct from interfaces to bean  "+beanClassName+ " method " +method.getName());
                        }
                    }
                }

            }
        }
    }
}
