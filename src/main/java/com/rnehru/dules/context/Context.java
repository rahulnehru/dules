package com.rnehru.dules.context;

import java.util.List;

public class Context {
    private final List<Page> pages;

    public Context(List<Page> pages) {
        this.pages = pages;
    }

    public List<Page> getPages() {
        return this.pages;
    }
}

