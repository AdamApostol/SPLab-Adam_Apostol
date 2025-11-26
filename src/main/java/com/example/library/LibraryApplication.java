package com.example.library;

import com.example.library.components.ClientComponent;
import com.example.library.components.SingletonComponent;
import com.example.library.components.TransientComponent;
import com.example.library.controller.BookController;
import com.example.library.controller.DemoController;
import com.example.library.helper.strategy.AllBooksSubject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LibraryApplication.class, args);

        System.out.println("=== Component Scope Demonstrations ===");
        TransientComponent transientBean1 = context.getBean(TransientComponent.class);
        transientBean1.operation();
        TransientComponent transientBean2 = context.getBean(TransientComponent.class);
        transientBean2.operation();

        SingletonComponent singletonBean1 = context.getBean(SingletonComponent.class);
        singletonBean1.operation();
        SingletonComponent singletonBean2 = context.getBean(SingletonComponent.class);
        singletonBean2.operation();

        ClientComponent client1 = context.getBean(ClientComponent.class);
        client1.operation();
        ClientComponent client2 = (ClientComponent) context.getBean("clientComponent");
        client2.operation();

        System.out.println("\n Controller Beans ");
        BookController bookController = context.getBean(BookController.class);
        System.out.println("BookController bean: " + bookController);

        DemoController demoController = context.getBean(DemoController.class);
        System.out.println("DemoController bean: " + demoController);

        System.out.println("\n=== Application Started Successfully ===");
        System.out.println("BookController available at: http://localhost:8080/books");
        System.out.println("DemoController available at: http://localhost:8080/demo");
    }

    @Bean
    public AllBooksSubject allBooksSubject() {
        return new AllBooksSubject();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
