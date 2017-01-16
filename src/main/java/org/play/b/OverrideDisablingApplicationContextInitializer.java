package org.play.b;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class OverrideDisablingApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer ");
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        if (beanFactory instanceof DefaultListableBeanFactory) {
            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) beanFactory;
//            defaultListableBeanFactory.setAllowBeanDefinitionOverriding(false);
        }
        if (applicationContext instanceof AbstractRefreshableApplicationContext) {

            AbstractRefreshableApplicationContext context = (AbstractRefreshableApplicationContext) applicationContext;
            System.out.println("ApplicationContextInitializer set to false");
            context.setAllowBeanDefinitionOverriding(false);

        }
    }


}
