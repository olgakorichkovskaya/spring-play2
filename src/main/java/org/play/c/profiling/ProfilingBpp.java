package org.play.c.profiling;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

@Component
public class ProfilingBpp implements BeanPostProcessor {

    private Map<String, Class<?>> map = new HashMap<>();

    private ProfilingJmxController controller = new ProfilingJmxController();

    public ProfilingBpp() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        Class<?> beanClass = o.getClass();
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(s, beanClass);
        }
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        if (map.containsKey(s)) {
            Class<?> aClass = map.get(s);
            return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (controller.isEnabled()) {
                        long s = System.nanoTime();
                        out.println("Profiling ..");
                        Object invoke = method.invoke(bean, args);
                        long f = System.nanoTime();
                        out.println("Profiling finish " + (f - s));
                        return invoke;
                    }
                    return method.invoke(bean, args);
                }
            });
        }
        return bean;
    }
}
