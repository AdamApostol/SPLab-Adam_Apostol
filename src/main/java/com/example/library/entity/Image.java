package com.example.library.entity;

import com.example.library.helper.strategy.RenderContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Image implements Element {
    private String url;

    @Override
    public void print(RenderContext renderContext) {
        System.out.println("Image: " + url);
    }
}