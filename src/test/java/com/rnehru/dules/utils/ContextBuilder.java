package com.rnehru.dules.utils;

import com.rnehru.dules.context.Context;
import com.rnehru.dules.context.Page;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContextBuilder {

    private List<Page> pages = new ArrayList<>();

    public ContextBuilder withPageAnswer(@NotNull String p, String[][] qa) {
        Map<String, String> answers = new HashMap<>();
        if (null != qa) {
            for (String[] aQa : qa) {
                String q = aQa[0];
                String a = aQa[1];
                answers.put(q, a);
            }
            pages.removeIf(page -> page.getName().equals(p));
            pages.add(new Page(p, answers));
        }
        return this;
    }

    public Context build() {
        return new Context(this.pages);
    }

}