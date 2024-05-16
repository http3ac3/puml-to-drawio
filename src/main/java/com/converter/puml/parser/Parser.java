package com.converter.puml.parser;

import com.converter.puml.element.Element;

import java.util.List;

public interface Parser {
    List<Element> parse();
}
