package ru.shaco.springMVC_1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration
@ComponentScan("ru.shaco.springMVC_1")
@EnableWebMvc
//КЛАСС замена applicationContextMVC.xml
public class SpringConfig implements WebMvcConfigurer {
    private final ApplicationContext applicationContext;

    //Внедрение Application Context через аннотацию @Autowired.

    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    //Настройка Thymeleaf. Указываем дирректорию хранения представлений (view), а также их расширение
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        //Метод для установки источника представления
        templateEngine.setTemplateResolver(templateResolver());
        //Метод для включения компилятора SpringEL в выражениях SpringEL.
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    /*
    Реализация метода интерфейса WebMvcConfigurer. Реализуется в случае, если вместо стандартного шаблонизатора
    требуется использовать сторонний (в данном слчае Thymeleaf)
    */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        //Передаем указание использовать шаблонизатор Thymeleaf
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }
}
