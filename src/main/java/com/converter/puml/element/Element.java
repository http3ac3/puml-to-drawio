package com.converter.puml.element;

public abstract class Element {
    private final String keyword;
    public Element(String keyword) {
        this.keyword = keyword;
    }
    public String getKeyword() {
        return this.keyword;
    }
}
