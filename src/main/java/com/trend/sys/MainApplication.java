package com.trend.sys;

import org.apache.tapestry5.spring.TapestrySpringFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by kabburi on 8/5/2016.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class MainApplication implements ServletContextInitializer{
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("contextClass",
                "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");

        servletContext.setInitParameter("tapestry.app-package", "com.trend.sys");
        servletContext.setInitParameter("tapestry.use-external-spring-context", "true");
        FilterRegistration.Dynamic filter = servletContext.addFilter("app", TapestrySpringFilter.class);
        filter.addMappingForUrlPatterns(null, true, "/*");
    }
}
