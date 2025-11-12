package com.example.shop.bean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    public void getAllBeanTest() {
        for (String beanName : applicationContext.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }

        Assertions.assertThat(applicationContext.getBeanDefinitionNames()).contains("myBean");
    }

    @Test
    public void getOneBeanTest() {
        MyBean myBean1 = applicationContext.getBean(MyBean.class);
        MyBean myBean2 = applicationContext.getBean(MyBean.class);
        MyBean myBean3 = new MyBean();

        System.out.println(myBean1);
        System.out.println(myBean2);
        System.out.println(myBean3);

        Assertions.assertThat(myBean1).isSameAs(myBean2);
    }

}
