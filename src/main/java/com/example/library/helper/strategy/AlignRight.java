package com.example.library.helper.strategy;

import com.example.library.entity.Paragraph;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, RenderContext renderContext) {
        String text = paragraph.getText();
        int padding=Math.max(renderContext.getWidth()-text.length(),0);
        renderContext.print("".repeat(padding));
        renderContext.println(text);
    }
}
