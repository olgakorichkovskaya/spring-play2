package org.play.postinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

import static java.lang.System.out;

@Component
public class PostInitInvokerListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    ConfigurableListableBeanFactory factory;
//When context is created
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext context=contextRefreshedEvent.getApplicationContext();

        String[] names=context.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            if(name.equals("a") || name.equals("getA") || name.equals("org.play.b.A#0")){
                out.println("Bean def name :"+name);
            }
            try {
                Method[] methods = Class.forName(beanClassName).getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(PostInitialize.class)) {
                        Object bean = context.getBean(name);
                        Class<?> proxyClass = bean.getClass();
                        Method proxyClassMethod = proxyClass.getMethod(method.getName());
                        proxyClassMethod.invoke(bean);
                    }
                }
            }catch (Exception e){

            }
        }
    }
}
