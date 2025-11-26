package com.example.library.helper.strategy;

import lombok.*;
import java.io.PrintStream;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RenderContext {
    @Builder.Default
    private int width = 80;

    @Builder.Default
    private String indent = "";

    @Builder.Default
    private PrintStream out = System.out;

    public void println(String text) {
        out.println(indent + text);
    }

    public void print(String text) {
        out.print(indent + text);
    }

    public RenderContext withIndent(String extra) {
        return RenderContext.builder()
                .width(width)
                .out(out)
                .indent(indent + extra)
                .build();
    }
}