package com.example.library.entity;

import com.example.library.helper.strategy.RenderContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TableOfContents implements Element{
    private String content;

    @Override
    public void print(RenderContext renderContext) {
        System.out.print("TableOfContents " + content + "\n");
    }
}