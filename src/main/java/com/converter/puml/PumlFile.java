package com.converter.puml;

import com.converter.puml.element.Element;
import com.converter.puml.element.PumlClass;
import com.converter.puml.parser.Parser;
import com.converter.puml.parser.PumlClassParser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PumlFile {
    private final List<Element> elements = new ArrayList<>();
    private String content;
    public PumlFile(String filePath) {
        try {
            this.content = Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Unable to read puml file by path: " + filePath);
            System.exit(0);
        }
    }
    public void parse() {
        Parser parser = new PumlClassParser(content, new PumlClass().getKeyword());
        this.elements.addAll(parser.parse());
        System.out.println(elements);
    }
}
