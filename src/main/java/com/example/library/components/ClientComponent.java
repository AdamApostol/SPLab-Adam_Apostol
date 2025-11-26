package com.example.library.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientComponent {

    private final SingletonComponent singletonComponent;
    private final TransientComponent transientComponent;

    @Autowired
    public ClientComponent(SingletonComponent singletonComponent, TransientComponent transientComponent) {
        this.singletonComponent = singletonComponent;
        this.transientComponent = transientComponent;
    }

    public void operation() {
        System.out.println("ClientComponent is executing operation...");
        singletonComponent.operation();
        transientComponent.operation();
    }
}