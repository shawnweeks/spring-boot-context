package us.weeksconsulting.springbootcontext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class GlobalContext {
    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalContext.class);

    @Bean
    @Qualifier("globalContext")
    String getGlobalAppName() {
        LOGGER.info("Created GlobalName Bean");
        return "Global";
    };

    @Bean
    public ServletRegistrationBean<DispatcherServlet> app1(ApplicationContext parentContext) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setDetectAllHandlerMappings(false);
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.setParent(parentContext);
        applicationContext.register(AppContext1.class);
        applicationContext.refresh();
        dispatcherServlet.setApplicationContext(applicationContext);
        ServletRegistrationBean<DispatcherServlet> servletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet, true,"/app1/*");
        servletRegistrationBean.setName("app1");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean<DispatcherServlet> app2(ApplicationContext parentContext) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setDetectAllHandlerMappings(false);
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.setParent(parentContext);
        applicationContext.register(AppContext2.class);
        applicationContext.refresh();
        dispatcherServlet.setApplicationContext(applicationContext);
        ServletRegistrationBean<DispatcherServlet> servletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet, true,"/app2/*");
        servletRegistrationBean.setName("app2");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }
}
