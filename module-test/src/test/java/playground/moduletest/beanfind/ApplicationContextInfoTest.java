package playground.moduletest.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import playground.moduletest.AppConfig;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 Bean 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String i : beanDefinitionNames) {
            Object bean = ac.getBean(i); //타입을 모르니깐 Object 로 꺼내짐
            System.out.println("name = " + i + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 Bean 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String i : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(i);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(i); //타입을 모르니깐 Object 로 꺼내짐
                System.out.println("name = " + i + " object = " + bean);
            }
        }
    }
}
