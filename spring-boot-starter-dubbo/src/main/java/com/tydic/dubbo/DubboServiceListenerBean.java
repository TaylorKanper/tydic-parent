package com.tydic.dubbo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("rawtypes")
@Slf4j
public class DubboServiceListenerBean implements ApplicationListener, ApplicationContextAware {


    public DubboServiceListenerBean() {}
    public DubboServiceListenerBean(String appName) {
        this.appName = appName;
    }

    protected ApplicationContext ctx;

    @Getter
    @Setter
    public String appName;

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        if (event instanceof ContextRefreshedEvent) {
            // now you can do applicationContext.getBean(...)
            // ...
            if (appName != null) {
                log.info("{} boot successfully", appName);
            }
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

}