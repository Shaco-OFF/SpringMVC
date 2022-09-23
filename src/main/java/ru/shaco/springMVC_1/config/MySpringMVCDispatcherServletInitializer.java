package ru.shaco.springMVC_1.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//КЛАСС замена web.xml
public class MySpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //Указание пути к классу с кофигурацией Spring. Аналогично в web.xlm была ссылка на applicationContextMVC.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    /*
    Указание посылать все HTML запросы на dispatcher servlets. Аналогично в web.xlm:
    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
