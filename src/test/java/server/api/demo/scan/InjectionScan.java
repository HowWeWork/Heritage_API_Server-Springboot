package server.api.demo.scan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import server.api.demo.DemoApplication;

public class InjectionScan {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DemoApplication.class);

    @Test
    void scan() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name " + beanDefinitionName + " object = " +bean);
            }
        }
    }
}
