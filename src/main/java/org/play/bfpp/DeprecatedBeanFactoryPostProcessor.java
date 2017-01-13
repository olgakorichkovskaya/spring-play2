package org.play.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

//set up bean definition  - info about bean
//work much earlier that bean creation
@Component
public class DeprecatedBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        String[] beanDefinitionNames = factory.getBeanDefinitionNames();
        DefaultListableBeanFactory listableBeanFactory =(DefaultListableBeanFactory) factory;
        System.out.println("isAllowBeanDefinitionOverriding "+         listableBeanFactory.isAllowBeanDefinitionOverriding());

        for (String name : beanDefinitionNames) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            try {
                if (beanClassName != null) {
                    Class<?> aClass = Class.forName(beanClassName);
                    DeprecatedClass annotation = aClass.getAnnotation(DeprecatedClass.class);
                    if (annotation != null) {
                        beanDefinition.setBeanClassName(annotation.newImpl().getName());
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
