package com.converter.puml.element;

import java.util.ArrayList;
import java.util.List;

public class PumlClass extends Element {
    private final List<String> fields = new ArrayList<>();
    private final List<String> methods = new ArrayList<>();

    public PumlClass() {
        super("class");
    }

    public void addField(String field) {
        this.fields.add(field);
    }

    public void addMethod(String method) {
        this.methods.add(method);
    }

    public List<String> getFields() {
        return this.fields;
    }

    public List<String> getMethods() {
        return this.methods;
    }
}
