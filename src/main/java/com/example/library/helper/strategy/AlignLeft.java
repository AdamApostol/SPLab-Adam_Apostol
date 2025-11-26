package com.example.library.helper.strategy;

import com.example.library.entity.Paragraph;

public class AlignLeft implements AlignStrategy{

    @Override
    public void render(Paragraph paragraph, RenderContext renderContext) {
        renderContext.println(paragraph.getText());
    }
}
