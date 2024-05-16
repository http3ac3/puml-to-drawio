package com.converter.puml.parser;

import com.converter.puml.element.Element;

import java.util.List;

public class PumlClassParser implements Parser {
    @Override
    public List<Element> parse(String content) {
        System.out.println("Класс готов!");
        return null;
    }
}
