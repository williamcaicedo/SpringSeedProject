/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utb.softeng.springseedproject.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author william
 */
public class SpringWebAppInitializer implements WebApplicationInitializer{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //Spring IoC Container
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(ApplicationContextConfig.class);
        
        //Spring servlet and container registration
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "SpringDispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
    
}
