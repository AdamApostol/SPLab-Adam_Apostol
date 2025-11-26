package com.example.library.helper.strategy;

import com.example.library.entity.Paragraph;

public interface AlignStrategy {
    void render(Paragraph paragraph, RenderContext renderContext);
}