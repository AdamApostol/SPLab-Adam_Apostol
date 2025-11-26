package com.example.library.components;

import org.springframework.stereotype.Component;

@Component
public class SingletonComponent {

    public void operation() {
        System.out.println("Running operation from SingletonComponent instance: "+ this);}
}