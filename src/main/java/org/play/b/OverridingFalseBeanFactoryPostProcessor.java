package org.play.b;

import org.play.bfpp.DeprecatedClass;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

//set up bean definition  - info about bean
//work much earlier that bean creation
@Component
public class OverridingFalseBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        String[] beanDefinitionNames = factory.getBeanDefinitionNames();
        DefaultListableBeanFactory listableBeanFactory =(DefaultListableBeanFactory) factory;
        System.out.println("BeanFactoryPostProcessor : isAllowBeanDefinitionOverriding "+   listableBeanFactory.isAllowBeanDefinitionOverriding());
        listableBeanFactory.setAllowBeanDefinitionOverriding(false);
        System.out.println(" isAllowBeanDefinitionOverriding set to "+  listableBeanFactory.isAllowBeanDefinitionOverriding());

    }
}
