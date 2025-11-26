package com.example.library.entity;

import com.example.library.helper.strategy.RenderContext;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Section implements Element {
    private String title;
    private final List<Element> children = new ArrayList<>();

    @Override
    public void add(Element e) { children.add(e); }

    @Override
    public void remove(Element e) { children.remove(e); }

    @Override
    public Element get(int index) { return children.get(index); }

    @Override
    public void print(RenderContext context) {
        context.println("Section: " + (title == null ? "" : title));
        RenderContext childCtx = context.withIndent("  ");
        for (Element e : children) {
            e.print(childCtx);
        }
    }
}