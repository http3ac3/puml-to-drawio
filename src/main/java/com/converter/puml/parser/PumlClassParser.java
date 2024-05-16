package com.converter.puml.parser;

import com.converter.puml.element.Element;
import com.converter.puml.element.PumlClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PumlClassParser implements Parser {
    private String content;
    private final String keyword;
    public PumlClassParser(String content, String keyword) {
        this.content = content;
        this.keyword = keyword;
    }
    @Override
    public List<Element> parse() {
        List<Element> classes = new ArrayList<>();
        while (content.contains(keyword)) {
            String classStr = findFirst(keyword);
            removeEntry(classStr);
            Element pumlClass = new PumlClass(
                    extractName(classStr),
                    extractFields(classStr),
                    extractMethods(classStr));
            classes.add(pumlClass);
        }
        return classes;
    }

    public String findFirst(String keyword) {
        String afterClassContent = content.substring(content.indexOf(keyword));
        return afterClassContent.substring(
                0,
                afterClassContent.indexOf("}") + 1
        );
    }

    public String extractName(String classStr) {
        String classDefinition = classStr.substring(0, classStr.indexOf("{"));
        String[] parts = classDefinition.split(" ");
        return parts[1];
    }

    public void removeEntry(String classStr) {
        content = content.replace(classStr, "");
    }

    public List<String> extractFields(String classStr) {
        try {
            String[] fields = classStr.substring(
                    classStr.indexOf("{") + 1,
                    classStr.indexOf(classStr.contains("--") ? "--" : "}")
            ).split("\n");
            return Arrays.stream(fields)
                    .map(String::trim)
                    .filter(f -> !f.isEmpty())
                    .toList();
        } catch (StringIndexOutOfBoundsException e) {
            return null;
        }
    }

    private List<String> extractMethods(String classStr) {
        if (!classStr.contains("--")) return null;
        String[] methods = classStr.substring(
                classStr.indexOf("--") + 2,
                classStr.indexOf("}")
        ).split("\n");
        return Arrays.stream(methods)
                .map(String::trim)
                .filter(m -> !m.isEmpty())
                .toList();
    }
}
