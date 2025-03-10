package guru.springframework.spring6di.services;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware, BeanPostProcessor {

    private String javaVer;

    public LifeCycleDemoBean() {
        System.out.println("## I'm in the LifeCycleBeanConstructor");
    }

    @Value("${java.specification.version}")
    public void setJavaVer(String javaVer) {
        this.javaVer = javaVer;
        System.out.println("## 1. Properties Set. Java Ver: " + this.javaVer);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## 2. BeanNameAware. My Bean name is: " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## 3. BeanFactoryAware. Bean Factory has been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## 4. ApplicationContextAware. Application context has been set. " +
                "The name of the application: " + applicationContext.getDisplayName());
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("## 5. PostConstruct. The @PostConstruct annotated method was called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## 6. AfterPropertiesSet. Populating properties. The LifeCycleBean has its properties populated");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## 7. The @PreDestroy annotated method was called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## 8. DisposableBean.Destroy. THe LifeCycleBean has been terminated");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("## postProcessBeforeInitialization: " + beanName);
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("## postProcessAfterInitialization: " + beanName);

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
