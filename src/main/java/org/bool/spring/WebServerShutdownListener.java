package org.bool.spring;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.ResolvableType;

public class WebServerShutdownListener implements GenericApplicationListener {

    @Override
    public boolean supportsEventType(ResolvableType eventType) {
        return ApplicationFailedEvent.class.isAssignableFrom(eventType.toClass())
            || ContextClosedEvent.class.isAssignableFrom(eventType.toClass());
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        var context = event instanceof ApplicationFailedEvent failedEvent
            ? failedEvent.getApplicationContext()
            : (ApplicationContext) event.getSource();
        if (context instanceof ReactiveWebServerApplicationContext reactiveContext && reactiveContext.getWebServer() != null) {
            reactiveContext.getWebServer().destroy();
        }
    }
}
