package com.example.library.entity;

import com.example.library.helper.strategy.RenderContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TableEntity implements Element {
    private String description;

    @Override
    public void print(RenderContext renderContext) {

    }
}