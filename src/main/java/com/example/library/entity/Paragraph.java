package com.example.library.entity;

import com.example.library.helper.strategy.AlignLeft;
import com.example.library.helper.strategy.AlignStrategy;
import com.example.library.helper.strategy.RenderContext;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paragraph implements Element {
    private String text;
    private AlignStrategy textAlignment;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void print(RenderContext context) {
        if (textAlignment != null) {
            textAlignment.render(this, context);
        } else {
            new AlignLeft().render(this, context);
        }
    }
}