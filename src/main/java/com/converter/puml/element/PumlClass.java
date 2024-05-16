package com.converter.puml.element;

import java.util.ArrayList;
import java.util.List;

public class PumlClass extends Element {
    private String name;
    private List<String> fields;
    private List<String> methods;

    public PumlClass() {
        super("class");
    }

    public PumlClass(String name, List<String> fields, List<String> methods) {
        super("class");
        this.name = name;
        this.fields = fields;
        this.methods = methods;
    }

    public void setFields(String field) {
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
    public String getName() {
        return this.name;
    }
}
