package com.example.library.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TransientComponent {

    public void operation() {
        System.out.println("Running operation from TransientComponent instance: " +this);
}
}