package com.example.library.helper.strategy;

import com.example.library.entity.Paragraph;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, RenderContext renderContext) {
        String text = paragraph.getText();
        int padding=Math.max(0, renderContext.getWidth()-text.length()/2);
        renderContext.print("".repeat(padding));
        renderContext.println(text);
    }
}
